package com.spring.studentmanagement.services;

import com.spring.studentmanagement.exceptions.CourseNotFoundException;
import com.spring.studentmanagement.models.Course;
import com.spring.studentmanagement.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(rollbackFor = {Exception.class, CourseNotFoundException.class})
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourseById(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public Course getCourseById(Long courseId) throws CourseNotFoundException {
        log.info("Trying to getCourseById with param: courseId = {}", courseId);

        return this.courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException("Course not found!"));
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

}
