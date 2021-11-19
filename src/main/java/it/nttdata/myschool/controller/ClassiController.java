package it.nttdata.myschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.nttdata.myschool.repository.ClasseRepository;

@Controller
public class ClassiController {
    
    private ClasseRepository classeRepository;

    public ClassiController(ClasseRepository classeRepository){
        this.classeRepository=classeRepository;
    }

    //I metodi del controller ritornano sempre stringhe
    
    /**
     * in getmapping inseriamo il path sul quale facciamo la 
     * richiesta GET in http
     */
    @GetMapping("/classi")
    public String getClassi(Model model){
        model.addAttribute("classi", classeRepository.findAll());
        return "classi";
    }
}
