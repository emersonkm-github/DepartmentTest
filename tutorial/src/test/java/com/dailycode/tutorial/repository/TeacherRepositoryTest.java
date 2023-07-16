package com.dailycode.tutorial.repository;

import com.dailycode.tutorial.entity.Course;
import com.dailycode.tutorial.entity.Teacher;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    @Disabled
    public void saveTeacher(){
        Course courseChinese = Course.builder()
                .title("Chinese")
                .credit(8)
                .build();
        Course courseEEE = Course.builder()
                .title("EEE")
                .credit(8)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Tin")
                .lastName("WO")
                //.courses(List.of(courseChinese,courseEEE))
                .build();

        teacherRepository.save(teacher);
    }

}