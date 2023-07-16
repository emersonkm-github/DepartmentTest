package com.dailycode.tutorial.repository;

import com.dailycode.tutorial.entity.Guardian;
import com.dailycode.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("shabbir@gmail.com")
                .firstName("daman")
                .lastName("chan")
                //.guardianName("hoho")
               // .guardianEmail("hoho@gmail.com")
               // .guardianMobile("87452")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("to")
                .email("to@gmail.com")
                .mobile("878787878")
                .build();
        Student student = Student.builder()
                .firstName("go")
                .lastName("wong")
                .emailId("wonggo@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void findStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("o");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("to");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameAndLastName(){
        Student student = studentRepository.findByFirstNameAndLastName("go","wong");

        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("shabbir@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentFirstByEmailAddress() {
        String firstName = studentRepository.getStudentFirstByEmailAddress("shabbir@gmail.com");

        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printGetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("shabbir@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeParam("shabbir@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        int affectedRows = studentRepository.updateStudentNameByEmailId("nonono","shabbir@gmail.com");
        System.out.println("受影响的行数：" + affectedRows);
    }


}