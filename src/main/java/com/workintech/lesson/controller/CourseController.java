package com.workintech.lesson.controller;

import com.workintech.lesson.entity.Course;
import com.workintech.lesson.entity.CourseGpa;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private List<Course> courses;
    private CourseGpa lowCourseGpa;
    private CourseGpa mediumCourseGpa;
    private CourseGpa highCourseGpa;

    public CourseController(@Qualifier("lowCourseGpa") CourseGpa firstCourseGpa,
                            @Qualifier("mediumCourseGpa") CourseGpa secondCourseGpa,
                            @Qualifier("highCourseGpa") CourseGpa thirdCourseGpa) {
        this.lowCourseGpa = firstCourseGpa;
        this.mediumCourseGpa = secondCourseGpa;
        this.highCourseGpa = thirdCourseGpa;
    }

    @PostConstruct
    public void init() {
        courses = new ArrayList<>();
    }


    @GetMapping("/hi")
    public String sayHi() {
        return "Hello";
    }
}
