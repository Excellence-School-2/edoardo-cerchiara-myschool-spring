package it.nttdata.myschool.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.nttdata.myschool.entities.Alunno;
import it.nttdata.myschool.entities.Classe;
import it.nttdata.myschool.repository.AlunnoRepository;
import it.nttdata.myschool.repository.ClasseRepository;

/**
 * Con la notazione component specifichiamo che la classe fa da bean
 */
 /**
     * Questa è la classe con la quale creiamo il database 
     * all'interno del quale ci sono i dati della nostra app
     */
@Component
public class BootstrapData implements CommandLineRunner{

    //in questa classe non possiamo modificare i repository, quindi sono final
    private final AlunnoRepository alunnoRepository;
    private final ClasseRepository classeRepository;
   
    //al costruttore ovviamente passiamo i nostri repository
    public BootstrapData(AlunnoRepository alunnoRepository,ClasseRepository classeRepository){
        this.alunnoRepository=alunnoRepository;
        this.classeRepository=classeRepository;
    }

    


    /**
     * Nel metodo run creiamo le classi che ci servono, generiamo i dati
     * sottoforma di oggetti
     */
    @Override
    public void run(String... args) throws Exception {
        
        Classe classe1 = new Classe("1A");
        Classe classe2 = new Classe("1B");
        Classe classe3 = new Classe("3G");

        Alunno studente1 = new Alunno("Mario","Rossi",12);
        Alunno studente2 = new Alunno("Giulia","Rossini",12);
        Alunno studente3 = new Alunno("Valerio","Neri",11);
        Alunno studente4 = new Alunno("Mario","Gialli",12);
        Alunno studente5 = new Alunno("Ugo","Bianchi",13);
        Alunno studente6 = new Alunno("Luca","Verdi",12);

        //Associamo gli studenti alle classi con il setter appropriato

        studente1.setClasse(classe1);
        studente2.setClasse(classe1);
        studente3.setClasse(classe2);
        studente4.setClasse(classe2);
        studente5.setClasse(classe3);
        studente6.setClasse(classe3);

        //Salviamo i dati creati nel db sfruttando i repository. Si salva 
        //sempre prima la classe forte, quella dell'id, quindi in questo caso
        //la classe Classe.

        classeRepository.save(classe1);
        classeRepository.save(classe2);
        classeRepository.save(classe3);


        alunnoRepository.save(studente1);
        alunnoRepository.save(studente2);
        alunnoRepository.save(studente3);
        alunnoRepository.save(studente4);
        alunnoRepository.save(studente5);
        alunnoRepository.save(studente6);
    }
    
   
}
