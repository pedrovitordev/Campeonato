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
public class ListJogosDTO {

    private int idJogo;

    private String nomeTimeA;

    private String nomeTimeB;

    private int numeroGolsTimeA;

    private int numeroGolsTimeB;

    private String vencedor;
    
    
    public ListJogosDTO() {
    }

    public ListJogosDTO(int idJogo, String nomeTimeA, String nomeTimeB, int numeroGolsTimeA, int numeroGolsTimeB, String vencedor) {
        this.idJogo = idJogo;
        this.nomeTimeA = nomeTimeA;
        this.nomeTimeB = nomeTimeB;
        this.numeroGolsTimeA = numeroGolsTimeA;
        this.numeroGolsTimeB = numeroGolsTimeB;
        this.vencedor = vencedor;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getNomeTimeA() {
        return nomeTimeA;
    }

    public void setNomeTimeA(String nomeTimeA) {
        this.nomeTimeA = nomeTimeA;
    }

    public String getNomeTimeB() {
        return nomeTimeB;
    }

    public void setNomeTimeB(String nomeTimeB) {
        this.nomeTimeB = nomeTimeB;
    }

    public int getNumeroGolsTimeA() {
        return numeroGolsTimeA;
    }

    public void setNumeroGolsTimeA(int numeroGolsTimeA) {
        this.numeroGolsTimeA = numeroGolsTimeA;
    }

    public int getNumeroGolsTimeB() {
        return numeroGolsTimeB;
    }

    public void setNumeroGolsTimeB(int numeroGolsTimeB) {
        this.numeroGolsTimeB = numeroGolsTimeB;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    
}
