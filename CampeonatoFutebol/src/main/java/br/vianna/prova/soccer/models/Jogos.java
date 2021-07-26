/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.prova.soccer.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.wildfly.common.annotation.NotNull;

/**
 *
 * @author PedroVitorDev
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Jogos {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idJogo;
    

    @JoinColumn(name = "timeA", referencedColumnName = "idTime")   
    @ManyToOne(optional = true)
    private Time timeA;
    
    @JoinColumn(name = "timeB", referencedColumnName = "idTime")
    @ManyToOne(optional = true)
    private Time timeB;
      
       
    @NotNull
    private int numeroGolsTimeA;
    
    @NotNull
    private int numeroGolsTimeB;
       
    
    private String vencedor;
    
    
    public Jogos() {
    }

    public Jogos(int idJogo, Time timeA, Time timeB, int numeroGolsTimeA, int numeroGolsTimeB, String vencedor) {
        this.idJogo = idJogo;
        this.timeA = timeA;
        this.timeB = timeB;
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

    public Time getTimeA() {
        return timeA;
    }

    public void setTimeA(Time timeA) {
        this.timeA = timeA;
    }

    public Time getTimeB() {
        return timeB;
    }

    public void setTimeB(Time timeB) {
        this.timeB = timeB;
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
