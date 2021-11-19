package it.nttdata.myschool.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Specifichiamo ovviamente che la classe sia un'entità
 */

@Entity
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sezione;
   

    /**
     * Una classe ha più studenti, quindi si usa il one to many, 
     * che richiede l'attributo mappedby, che in questo caso è la 
     * classe stessa (scrivere sempre in minuscolo)
     */
    @OneToMany(mappedBy = "classe")
    private List<Alunno> listaStudenti = new ArrayList<>();

    /**
     * Torniamo il numero di studenti della classe
     */
    public int getNumeroStudenti(){
        return listaStudenti.size();
    }

    public String getSezione() {
        return sezione;
    }

    public void setSezione(String sezione) {
        this.sezione = sezione;
    }

    public List<Alunno> getListaStudenti() {
        return listaStudenti;
    }

    public void setListaStudenti(List<Alunno> listaStudenti) {
        this.listaStudenti = listaStudenti;
    }

    //Costruttore
    public Classe(String sezione){
        this.sezione=sezione;
    }

    //costruttore vuoto che spring vuole SEMPRE per le entities
    public Classe(){}
    
}
