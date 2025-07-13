package com.example.eduapp.application.repository;

import com.example.eduapp.application.domain.Application;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ApplicationRepository {

    private final EntityManager em;


    public Application save(Application application) {
        em.persist(application);
        return application;
    }
}
