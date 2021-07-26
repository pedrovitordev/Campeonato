/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.prova.soccer.models;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.wildfly.common.annotation.NotNull;

/**
 *
 * @author PedroVitorDev
 */
@Entity
public class Time {
    
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idTime;

    @NotNull
    private String nome;
    
    @NotNull
    private String sigla;
    
    @NotNull
    private String anoDeFund;
    
    @NotNull
    private int classificacao;

    @NotNull
    private ArrayList<Jogos> j;
    
    private int pontuacao; 
    
    
    public Time() {
    }

    public Time(int idTime, String nome, String sigla, String anoDeFund, int classificacao, ArrayList<Jogos> j, int pontuacao) {
        this.idTime = idTime;
        this.nome = nome;
        this.sigla = sigla;
        this.anoDeFund = anoDeFund;
        this.classificacao = classificacao;
        this.j = j;
        this.pontuacao = pontuacao;
    }

   
    public Time(int idTime, String nome, String sigla, String anoDeFund, int classificacao) {
        this.idTime = idTime;
        this.nome = nome;
        this.sigla = sigla;
        this.anoDeFund = anoDeFund;
        this.classificacao = classificacao;
    }

      
    public int getIdTime() {
        return idTime;
    }

    public void setIdTime(int idTime) {
        this.idTime = idTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getAnoDeFund() {
        return anoDeFund;
    }

    public void setAnoDeFund(String anoDeFund) {
        this.anoDeFund = anoDeFund;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public ArrayList<Jogos> getJ() {
        return j;
    }

    public void setJ(ArrayList<Jogos> j) {
        this.j = j;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    
    

    
    
}
