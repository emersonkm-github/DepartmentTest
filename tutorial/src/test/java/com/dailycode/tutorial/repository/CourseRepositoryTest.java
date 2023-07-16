package com.dailycode.tutorial.repository;

import com.dailycode.tutorial.entity.Course;
import com.dailycode.tutorial.entity.Student;
import com.dailycode.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void findAllCourse(){
        List<Course> courses = courseRepository.findAll();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Ko")
                .lastName("Ma")
                .build();
        Course course = Course.builder()
                .title("IT")
                .credit(5)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
        System.out.println("courses = " + courses);

        Long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();

        System.out.println("totalElements = " + totalElements);

        Integer totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println("totalPages = " + totalPages);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(0,2, Sort.by("title"));

        Pageable sorByCreditDesc =
                PageRequest.of(0,2,Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0,2,Sort.by("title")
                        .and(Sort.by("credit").descending()));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }
    @Test
    public void findByTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses = courseRepository.findByTitleContaining("C",firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Pla")
                .lastName("Ja")
                .build();
        Student student = Student.builder()
                .firstName("Qlo")
                .lastName("Vivi")
                .emailId("vivi@gmail.com")
                .build();
        Course course = Course.builder()
                .title("Java")
                .credit(9)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);

    }

}