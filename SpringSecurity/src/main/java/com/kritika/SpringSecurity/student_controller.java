package com.kritika.SpringSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class student_controller {

    private List<student> students=new ArrayList<>(
            (List.of(
                    new student(1,"kt",10),
                    new student(3,"isi",7),
                    new student(8,"jika",8)
            ))
    );

@GetMapping(value = "/student")
    public List<student> getStudents(){
      return students;
    }


}
