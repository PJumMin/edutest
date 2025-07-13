package com.example.eduapp.application.dto;

import lombok.Data;

public class ApplicationResponse {

    @Data
    public static class SaveDTO {
        private Long employeeId;
        private Long courseId;

        public SaveDTO(Long employeeId, Long courseId) {
            this.employeeId = employeeId;
            this.courseId = courseId;
        }
    }

}
