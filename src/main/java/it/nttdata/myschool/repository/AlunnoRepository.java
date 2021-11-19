package it.nttdata.myschool.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.nttdata.myschool.entities.Alunno;

public interface AlunnoRepository extends CrudRepository<Alunno,Long>{
    
    /**
     * L'interfaccia CrudRepository vuole la classe e il tipo dell'id 
     * specificato nella classe. Ricordiamo che il repository ci permette
     * di fare le operazioni sul DB
     */

     //Query in formato jpa (Alunno è la classe e alunni il nome della tabella che stiamo dando in questo momento)
     @Query("SELECT alunni FROM Alunno alunni WHERE alunni.classe = :sezione ")
     public Collection<Alunno> findStudentiByClasse(@Param("sezione") String sezione);

}
