/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.prova.soccer.dto;

/**
 *
 * @author PedroVitorDev
 */
public class ListTimeDTO {
    
    private int idTime;
    
    private String nome;

    private String sigla;
    
    private String anoDeFund;
    
    private int classificacao;
    
    private int pontuacao;

    public ListTimeDTO() {
    }

    public ListTimeDTO(int idTime, String nome, String sigla, String anoDeFund, int classificacao) {
        this.idTime = idTime;
        this.nome = nome;
        this.sigla = sigla;
        this.anoDeFund = anoDeFund;
        this.classificacao = classificacao;
    }

    public ListTimeDTO(int idTime, String nome, String sigla, String anoDeFund, int classificacao, int pontuacao) {
        this.idTime = idTime;
        this.nome = nome;
        this.sigla = sigla;
        this.anoDeFund = anoDeFund;
        this.classificacao = classificacao;
        this.pontuacao = pontuacao;
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

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    
    
    
    
    
    
}
