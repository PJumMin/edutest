package com.example.eduapp.application.dto;

import com.example.eduapp.application.domain.Application;
import com.example.eduapp.course.domain.Course;
import com.example.eduapp.employee.domain.Employee;
import lombok.Data;

public class ApplicationRequest {

    @Data
    public static class SaveDTO {
        private Long employeeId;
        private Long courseId;

        public Application toEntity(Employee employee, Course course) {
            return Application.builder()
                    .employee(employee)
                    .course(course)
                    .build();
        }
    }
}
