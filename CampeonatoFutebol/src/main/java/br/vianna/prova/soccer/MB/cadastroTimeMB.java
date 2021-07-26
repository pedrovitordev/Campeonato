/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.prova.soccer.MB;

import br.vianna.prova.soccer.dao.timeDao;
import br.vianna.prova.soccer.dto.ListJogosDTO;
import br.vianna.prova.soccer.dto.ListTimeDTO;
import br.vianna.prova.soccer.models.Time;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
@Component(value = "cadTime")
@ViewScoped
public class cadastroTimeMB implements Serializable {

    private EStatusCrud status;

    private ArrayList<ListTimeDTO> lista;
    
     private ArrayList<ListTimeDTO> listaTotal;

    private Time time;

    private String valor; //campo de pesquisar
    
    
    @Autowired
    private timeDao timeDao;

//    private String pesquisar; //auxilar para pesquisar por nome
    public cadastroTimeMB() {

        status = EStatusCrud.VIEW;
        inicializaTime();
        lista = new ArrayList<>();

    }

    private void inicializaTime() {
        time = new Time();
        time.setClassificacao(0); //inicializando classificação como 0
    }

     
    public String pesqNome() {

        if (getValor().equals("")) {
            lista = timeDao.getAllTimes();
        } else {
            lista = timeDao.FindNome(getValor());   
        }
        return "";
    }
    
    
    public String pesqNomeList() {

        if (getValor().equals("")) {
            listaTotal = timeDao.getAllListagem();
        } else {
            listaTotal = timeDao.FindNome(getValor());
        }
        return "";
    }
    
    
     
    @PostConstruct
    public void init() {

        lista = timeDao.getAllTimes();   //pra inicializar quando entrar na pagina
        listaTotal = timeDao.getAllListagem();

    }

       
    public String editarTime(int id) {

        status = EStatusCrud.EDIT;

        time = timeDao.getTime(id);

        return "";

    }

    public String deletarTime(int id) {

        FacesContext ct = FacesContext.getCurrentInstance();

        timeDao.deleteTime(id);

        ct.addMessage("", new FacesMessage("O time foi apagado com sucesso!!"));

        lista = timeDao.getAllTimes();

        return "";

    }

    public String salvar() {

        FacesContext ct = FacesContext.getCurrentInstance();

        timeDao.save((Time) time);
        inicializaTime();
        status = EStatusCrud.VIEW; //voltando para tela anterior

        lista = timeDao.getAllTimes(); //inicalizando para aparecer na tabela

        ct.addMessage("", new FacesMessage("O time foi cadastrado com sucesso!!"));

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

    public ArrayList<ListTimeDTO> getLista() {
        return lista;
    }

    public void setLista(ArrayList<ListTimeDTO> lista) {
        this.lista = lista;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ArrayList<ListTimeDTO> getListaTotal() {
        return listaTotal;
    }

    public void setListaTotal(ArrayList<ListTimeDTO> listaTotal) {
        this.listaTotal = listaTotal;
    }
    
    
    
    
    

}
