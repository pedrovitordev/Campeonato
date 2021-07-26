/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.prova.soccer.dao;

import br.vianna.prova.soccer.dto.ListJogosDTO;
import br.vianna.prova.soccer.models.Jogos;
import br.vianna.prova.soccer.models.Time;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PedroVitorDev
 */
@Component
public class jogoDao {

    private String src = "br.vianna.prova.soccer.dto.";

    @Autowired
    private EntityManager con;

    public ArrayList<ListJogosDTO> getAlljogos() {

        Query q = con.createQuery("select new " + src + "ListJogosDTO(j.idJogo, j.timeA.nome, j.timeB.nome, j.numeroGolsTimeA,j.numeroGolsTimeB, j.vencedor)"
                + "from Jogos j ");

        return (ArrayList<ListJogosDTO>) q.getResultList();
    }

    @Transactional
    public Jogos save(Jogos j) {

        if (j.getIdJogo() > 0) {
            con.merge(j);
        } else {
            con.persist(j);
        }
        return j;
    }

    public Jogos getJogo(int id) {

        return con.find(Jogos.class, id);
    }

    @Transactional
    public Jogos deleteJogo(int id) {

        Jogos j = getJogo(id); //pegando id
        con.remove(j);
        return j;
    }

    
    
    public ArrayList<ListJogosDTO> FindNome(String valor) {
        
         Query q = con.createQuery("select new " + src + "ListJogosDTO(j.idJogo, j.timeA.nome, j.timeB.nome, j.numeroGolsTimeA,j.numeroGolsTimeB, j.vencedor)"
                + "from Jogos j "
                 + " where j.timeA.nome like :nome "); //pensar em possibilidade em trazer o time b no filtro

        q.setParameter("nome", valor);
         
        return (ArrayList<ListJogosDTO>) q.getResultList();
        
    }
    
    
    
    
}
