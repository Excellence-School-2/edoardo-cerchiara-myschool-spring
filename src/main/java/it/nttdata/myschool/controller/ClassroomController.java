package it.nttdata.myschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.nttdata.myschool.repository.ClassroomRepository;

@Controller
public class ClassroomController {

    private ClassroomRepository classroomRepository;

    public ClassroomController(ClassroomRepository classroomRepository){
        this.classroomRepository = classroomRepository;
    }

    @GetMapping("/classes")
    public String getSchoolClass(Model model){
        model.addAttribute("classrooms", classroomRepository.findAll());
        return "classrooms";
    }
    
}