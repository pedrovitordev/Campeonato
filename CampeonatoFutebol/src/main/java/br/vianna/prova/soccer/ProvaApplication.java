package br.vianna.prova.soccer;

import br.vianna.prova.soccer.dao.jogoDao;
import br.vianna.prova.soccer.dao.timeDao;
import br.vianna.prova.soccer.models.Jogos;
import br.vianna.prova.soccer.models.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProvaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProvaApplication.class, args);
    }

    @Autowired
    timeDao timeD;

    @Autowired
    jogoDao jogoD;
    
      
    @Override
    public void run(String... args) throws Exception {

        System.out.println("Servidor On!!");

//        Time t = new Time(0, "Chelsea", "cs", "1998", 0, null, 0);
//        Time t2 = new Time(0, "Flamengo", "fla", "1999", 0, null ,0);     
//        Jogos j = new Jogos(0, t, t2, 1, 5, null );
//        Jogos j2 = new Jogos(0, t, t2, 4, 3, null );
//        
//        timeD.save(t);
//        timeD.save(t2);
//        jogoD.save(j);
//        jogoD.save(j2);

              
    }

}
