package com.dailycode.tutorial.repository;

import com.dailycode.tutorial.entity.Course;
import com.dailycode.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;
    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title(".you")
                .credit(6)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.you.com")
                //.course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void findAllCourseMaterial(){
        List<CourseMaterial> courseMaterials = repository.findAll();

        System.out.println("courseMaterials = " + courseMaterials);
    }

}