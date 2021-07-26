/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.prova.soccer.MB;

import br.vianna.prova.soccer.dao.jogoDao;
import br.vianna.prova.soccer.dao.timeDao;
import br.vianna.prova.soccer.dto.ListJogosDTO;
import br.vianna.prova.soccer.dto.ListTimeDTO;
import br.vianna.prova.soccer.models.Jogos;
import br.vianna.prova.soccer.models.Time;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author PedroVitorDev
 */
@Component(value = "cadJogo")
@ViewScoped
public class cadastroJogoMB implements Serializable {

    private EStatusCrud status;

    private ArrayList<ListJogosDTO> lista;

    private Jogos jogos;

    private Time times;

    private String v1, v2;

    private String valor;

    private int TimeAselecionado; //auxiliar pra salvar

    private int TimeBselecionado; //auxiliar pra salvar

    private int idV1, idV2;

    @Autowired
    cadastroTimeMB cadTime;

    @Autowired
    private jogoDao jogoDao;

    @Autowired
    private timeDao timeD;

    public cadastroJogoMB() {

        status = EStatusCrud.VIEW;
        inicializaJogo();
        lista = new ArrayList<>();

    }

    public void inicializaJogo() {

        jogos = new Jogos();
    }

    public String pesqNome() {

        if (getValor().equals("")) {
            lista = jogoDao.getAlljogos();

        } else {

            lista = jogoDao.FindNome(getValor());
        }
        return "";
    }

    @PostConstruct
    public void init() {

        lista = jogoDao.getAlljogos();
    }

    public String editarJogo(int id) {

        status = EStatusCrud.EDIT;

        jogos = jogoDao.getJogo(id);

        return "";

    }

    public String deletarJogo(int id) {

        FacesContext ct = FacesContext.getCurrentInstance();

        jogoDao.deleteJogo(id);

        ct.addMessage("", new FacesMessage("O jogo foi apagado com sucesso!!"));

        lista = jogoDao.getAlljogos();

        return "";

    }

    public String salvar() {

        FacesContext ct = FacesContext.getCurrentInstance();
        identificarTime();
        jogoDao.save((Jogos) jogos);
        inicializaJogo();
        status = EStatusCrud.VIEW; //voltando para tela anterior
        lista = jogoDao.getAlljogos(); //inicalizando para aparecer na tabela
        ct.addMessage("", new FacesMessage("O jogo foi cadastrado com sucesso!!"));
        return "";

    }

    // testar questão de pontuação
    public String vencedor(String nomeA, int idV1, int idV2, String nomeB) {

        if (jogos.getNumeroGolsTimeA() > jogos.getNumeroGolsTimeB()) {
            
            jogos.setVencedor(nomeA);
            timeD.acresPont(idV1);
            return "";
        }

        if (jogos.getNumeroGolsTimeA() < jogos.getNumeroGolsTimeB()) {
            jogos.setVencedor(nomeB);
            timeD.acresPont(idV2);
        }

        if (jogos.getNumeroGolsTimeA() == jogos.getNumeroGolsTimeB()) {

            jogos.setVencedor("Empate");
            timeD.acresPontEmpate(idV1, idV2);
                     
        }
        return "";
    }

    public String identificarTime() {

        ArrayList<ListTimeDTO> listaTimes = cadTime.getLista();

        for (ListTimeDTO time : listaTimes) {

            if (time.getIdTime() == TimeAselecionado) {

                jogos.setTimeA(new Time(time.getIdTime(), time.getNome(), time.getSigla(), time.getAnoDeFund(), time.getClassificacao()));

                setV1(time.getNome());
                setIdV1(time.getIdTime());
            }

            if (time.getIdTime() == TimeBselecionado) {

                jogos.setTimeB(new Time(time.getIdTime(), time.getNome(), time.getSigla(), time.getAnoDeFund(), time.getClassificacao()));

                setV2(time.getNome());
                setIdV2(time.getIdTime());
            }
        }

        vencedor(v1,idV1,idV2,v2);

        return "";
    }

    public String trocar() {

        status = EStatusCrud.INSERT;

        return "";

    }

    public String voltar() {

        status = EStatusCrud.VIEW;

        return "";

    }

    public EStatusCrud getStatus() {
        return status;
    }

    public void setStatus(EStatusCrud status) {
        this.status = status;
    }

    public ArrayList<ListJogosDTO> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ListJogosDTO> lista) {
        this.lista = lista;
    }

    public Jogos getJogos() {
        return jogos;
    }

    public void setJogos(Jogos jogos) {
        this.jogos = jogos;
    }

    public Time getTimes() {
        return times;
    }

    public void setTimes(Time times) {
        this.times = times;
    }

    public int getTimeAselecionado() {
        return TimeAselecionado;
    }

    public void setTimeAselecionado(int TimeAselecionado) {
        this.TimeAselecionado = TimeAselecionado;
    }

    public int getTimeBselecionado() {
        return TimeBselecionado;
    }

    public void setTimeBselecionado(int TimeBselecionado) {
        this.TimeBselecionado = TimeBselecionado;
    }

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public String getV2() {
        return v2;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getIdV1() {
        return idV1;
    }

    public void setIdV1(int idV1) {
        this.idV1 = idV1;
    }

    public int getIdV2() {
        return idV2;
    }

    public void setIdV2(int idV2) {
        this.idV2 = idV2;
    }

}
