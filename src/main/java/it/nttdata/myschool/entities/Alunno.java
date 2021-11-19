package it.nttdata.myschool.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Alunno {
    /**
     * Con le notazione id diciamo a spring che quello è l'id della tabella
     * che verrà creata, e con generatedvalue e strategy AUTO diciamo che l'
     * id è autoincrementale
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String cognome;
    private Integer eta;

    /**
     * Più alunni in una sola classe, in questo caso specifichiamo 
     * la join column, che vuole il nome della colonna di join, in 
     * questo caso il nome della classe, che si scrive tutto minuscolo
     * con _id, per far capire che è l'id della classe la descriminante 
     */
    @ManyToOne
    @JoinColumn(name="classe_id")
    private Classe classe;

    

    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public Integer getEta() {
        return eta;
    }
    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public Alunno(){}

    public Alunno(String nome, String cognome,Integer eta){
        this.nome=nome;
        this.cognome=cognome;
        this.eta=eta;
    }

    




}
