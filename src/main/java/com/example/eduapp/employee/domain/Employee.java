package com.example.eduapp.employee.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Table(name = "employee_tb")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @Column(unique = true)
    private String email;

    // 기본 생성자
    protected Employee() {
    }

    @Builder
    public Employee(Long id, String name, String description, String email) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.email = email;
    }
}
