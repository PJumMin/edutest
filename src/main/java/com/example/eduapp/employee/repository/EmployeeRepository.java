package com.example.eduapp.employee.repository;

import com.example.eduapp.employee.domain.Employee;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {

    private final EntityManager em;

    public Employee save(Employee employee) {
        em.persist(employee);
        return employee;
    }
}
