/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.prova.soccer.MB;

import javax.faces.bean.RequestScoped;
import org.springframework.stereotype.Component;

/**
 *
 * @author PedroVitorDev
 */

@Component
@RequestScoped
public class templateMB {
    
     
    public String home(){
    
        return "index?faces-redirect=true";
    
    }
    
    public String cadastroTime(){
    
        return "cadastroTime?faces-redirect=true";
    
    }
    
    public String cadastroJogos(){
    
        return "cadastroJogos?faces-redirect=true";
    
    }
    
     public String listagem(){
    
        return "listagemCampeonato?faces-redirect=true";
    
    }
    
    
}
