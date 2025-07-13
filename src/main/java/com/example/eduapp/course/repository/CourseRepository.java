package com.example.eduapp.course.repository;

import com.example.eduapp.course.domain.Course;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CourseRepository {

    private final EntityManager em;

    public Course save(Course course) {
        em.persist(course);
        return course;
    }

    public Optional<Course> findById(Long courseId) {
        Course coursePS = em.find(Course.class, courseId);
        return Optional.ofNullable(coursePS);

    }


    public Optional<Course> findBytitle(String title) {
        try {
            Course CoursePS = em.createQuery("select c from Course c where c.title = :title", Course.class)
                    .setParameter("title", title)
                    .getSingleResult();
            return Optional.of(CoursePS);
        } catch (Exception e) {
            return Optional.ofNullable(null);
        }
    }
}
