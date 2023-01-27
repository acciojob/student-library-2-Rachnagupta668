package com.driver.controller;

import com.driver.models.Card;
import com.driver.models.Student;
import com.driver.repositories.StudentRepository;
import com.driver.services.CardService;
import com.driver.services.StudentService;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private static Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    CardService cardService;

    @Autowired
    StudentRepository studentRepository;


    public Student getDetailsByEmail(String email){
        return studentRepository.findByEmailId(email);
    }

    public Student getDetailsById(int id){
        return studentRepository.findById(id).get();
    }

    public void createStudent(Student student){
        Card newCard = cardService.createAndReturn(student);
    }

    public void updateStudent(Student student){
        studentRepository.updateStudentDetails(student);
    }

    public void deleteStudent(int id){
        cardService.deactivateCard(id);
        studentRepository.deleteCustom(id);
    }
}
