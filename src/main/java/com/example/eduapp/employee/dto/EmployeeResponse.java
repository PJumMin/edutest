package com.example.eduapp.employee.dto;

import com.example.eduapp.employee.domain.Employee;
import lombok.Data;

public class EmployeeResponse {

    @Data
    public static class SaveDTO {
        private String name;
        private String department;
        private String email;

        public SaveDTO(Employee employee) {
            this.name = employee.getName();
            this.department = employee.getDescription();
            this.email = employee.getEmail();
        }
    }
}
