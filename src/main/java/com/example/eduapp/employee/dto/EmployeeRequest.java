package com.example.eduapp.employee.dto;

import com.example.eduapp.employee.domain.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class EmployeeRequest {

    @Data
    public static class SaveDTO {
        @NotBlank(message = "직원 이름은 필수입니다.")
        private String name;
        private String department;

        @NotBlank(message = "이메일은 필수입니다.")
        @Email(message = "이메일 형식으로 입력해주세요.")
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
