package com.spring.studentmanagement.services;

import com.spring.studentmanagement.exceptions.CourseNotFoundException;
import com.spring.studentmanagement.models.Course;

import java.util.List;


public interface CourseService {
    List<Course> findAllCourses();

    void deleteCourseById(Long courseId);

    Course getCourseById(Long courseId) throws CourseNotFoundException;

    Course saveCourse(Course course);
}
