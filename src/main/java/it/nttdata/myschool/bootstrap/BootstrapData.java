package it.nttdata.myschool.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.nttdata.myschool.entities.Classroom;
import it.nttdata.myschool.entities.Student;
import it.nttdata.myschool.repository.ClassroomRepository;
import it.nttdata.myschool.repository.StudentRepository;



@Component
public class BootstrapData implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final ClassroomRepository classroomRepository;

    

    public BootstrapData(StudentRepository studentRepository, ClassroomRepository classroomRepository) {
        this.studentRepository = studentRepository;
        this.classroomRepository = classroomRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        Classroom classroom1 = new Classroom("1A");
        Classroom classroom2 = new Classroom("2B");
        Classroom classroom3 = new Classroom("3C");

        Student student1 = new Student("Mario", "Rossi", 12);
        Student student2 = new Student("Luca", "Gialli", 13);
        Student student3 = new Student("Pietro", "Giallini", 11);
        Student student4 = new Student("Mario", "Merola", 12);
        Student student5 = new Student("Giulio", "Neri", 12);
        Student student6 = new Student("Ubalda", "degliUbaldi", 12);

        student1.setClassroom(classroom1);
        student2.setClassroom(classroom1);

        student3.setClassroom(classroom2);
        student4.setClassroom(classroom2);

        student5.setClassroom(classroom3);
        student6.setClassroom(classroom3);

        classroomRepository.save(classroom1);
        classroomRepository.save(classroom2);
        classroomRepository.save(classroom3);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);

        

        
        
    }
    
    
}