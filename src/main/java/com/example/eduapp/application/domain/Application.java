package com.example.eduapp.application.domain;

import com.example.eduapp.course.domain.Course;
import com.example.eduapp.employee.domain.Employee;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Table(name = "application_tb")
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @CreationTimestamp
    private LocalDateTime appliedAt;

    @Builder
    public Application(Integer id, Employee employee, Course course, LocalDateTime appliedAt) {
        this.id = id;
        this.employee = employee;
        this.course = course;
        this.appliedAt = appliedAt;
    }

    // 기본 생성자
    protected Application() {
    }
}
