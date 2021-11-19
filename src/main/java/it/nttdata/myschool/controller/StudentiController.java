package it.nttdata.myschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.nttdata.myschool.repository.AlunnoRepository;

@Controller
public class StudentiController {

    private AlunnoRepository alunnoRepository;

    public StudentiController(AlunnoRepository alunnoRepository){
        this.alunnoRepository=alunnoRepository;
    }
    
    @GetMapping("/studenti")
    public String getStudenti(Model model){
        model.addAttribute("studenti", alunnoRepository.findAll());
        return "studenti";
    }

    @GetMapping("/studenti/{sezione}")
    public String getClasseComp(Model model, @PathVariable String sezione){
      
         model.addAttribute("studenti",alunnoRepository.findStudentiByClasse(sezione));
         model.addAttribute("titolo", "Lista Studenti");
         model.addAttribute("titolo", "Lista Studenti" + sezione);
        return "studenti";

    }
}
