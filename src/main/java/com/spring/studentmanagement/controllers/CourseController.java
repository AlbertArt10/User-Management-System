package com.spring.studentmanagement.controllers;

import com.spring.studentmanagement.models.Course;
import com.spring.studentmanagement.services.CourseService;
import com.spring.studentmanagement.services.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String getCoursesView(Model model) {
        final List<Course> courses = this.courseService.findAllCourses();
        model.addAttribute("courseList", courses);
        return "courses";
    }
}


