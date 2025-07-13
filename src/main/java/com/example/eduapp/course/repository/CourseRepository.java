package com.example.eduapp.course.repository;

import com.example.eduapp.course.domain.Course;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CourseRepository {

    private final EntityManager em;

    public Course save(Course course) {
        em.persist(course);
        return course;
    }
}
