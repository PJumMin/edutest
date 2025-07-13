package com.example.eduapp.application.repository;

import com.example.eduapp.application.domain.Application;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ApplicationRepository {

    private final EntityManager em;


    public Application save(Application application) {
        em.persist(application);
        return application;
    }

    public List<Application> findByCourseId(int userId) {
        Query query = em.createQuery("select a from Application a join fetch a.course join fetch a.employee where a.course.id = :userId", Application.class);
        query.setParameter("userId", userId);
        List<Application> courseList = query.getResultList();
        return courseList;
    }
}
