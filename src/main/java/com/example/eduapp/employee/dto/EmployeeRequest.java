package com.example.eduapp.employee.dto;

import com.example.eduapp.employee.domain.Employee;
import lombok.Data;

public class EmployeeRequest {

    @Data
    public static class SaveDTO {
        private String name;
        private String department;
        private String email;

        public Employee toEntity() {
            return Employee.builder()
                    .name(name)
                    .description(department)
                    .email(email)
                    .build();

        }
    }
}
