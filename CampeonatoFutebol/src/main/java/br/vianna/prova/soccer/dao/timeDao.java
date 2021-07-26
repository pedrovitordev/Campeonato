/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.prova.soccer.dao;

import br.vianna.prova.soccer.dto.ListTimeDTO;
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
public class timeDao {

    private String src = "br.vianna.prova.soccer.dto.";

    @Autowired
    private EntityManager con;

    public ArrayList<ListTimeDTO> getAllTimes() {

        Query q = con.createQuery("select new " + src + "ListTimeDTO(t.idTime,t.nome,t.sigla,t.anoDeFund,t.classificacao, t.pontuacao)"
                + "from Time t "
                + "order by t.anoDeFund desc");

        return (ArrayList<ListTimeDTO>) q.getResultList();
    }

    
    
    
    
    
    public ArrayList<ListTimeDTO> getAllListagem() {

        Query q = con.createQuery("select new " + src + "ListTimeDTO(t.idTime,t.nome,t.sigla,t.anoDeFund,t.classificacao, t.pontuacao)"
                + "from Time t "
                + "order by t.pontuacao desc");

        return (ArrayList<ListTimeDTO>) q.getResultList();
    }
    
    
        
        
        
        
        
    @Transactional
    public Time save(Time t) {

        if (t.getIdTime() > 0) {
            con.merge(t);
        } else {
            con.persist(t);
        }
        return t;
    }

    @Transactional
    public Time getTime(int id) {

        return con.find(Time.class, id);
    }

    @Transactional
    public void acresPont(int id) {

        Time time = getTime(id);

        if (time.getPontuacao() != 0) {

            int soma = time.getPontuacao() + 3;
            time.setPontuacao(soma);
            con.merge(time);

        } else {

            time.setPontuacao(3);
            con.merge(time);
        }
    }

    @Transactional
    public void acresPontEmpate(int idA, int idB){
    
    Time timeA = getTime(idA);
    Time timeB = getTime(idB);
    
    int emp = timeA.getPontuacao() + 1;
    timeA.setPontuacao(emp);

    int emp2 = timeB.getPontuacao() + 1;
    timeB.setPontuacao(emp2);
    
    con.merge(timeA);
    con.merge(timeB);
    
    }
    
   
    @Transactional
    public Time deleteTime(int id) {

        Time t = getTime(id); //pegando id
        con.remove(t);
        return t;
    }

    public ArrayList<ListTimeDTO> FindNome(String valor) {

        Query q = con.createQuery("select new " + src + "ListTimeDTO(t.idTime,t.nome,t.sigla,t.anoDeFund,t.classificacao)"
                + "from Time t "
                + "where t.nome like :nome");

        q.setParameter("nome", valor);

        return (ArrayList<ListTimeDTO>) q.getResultList();

    }

}
