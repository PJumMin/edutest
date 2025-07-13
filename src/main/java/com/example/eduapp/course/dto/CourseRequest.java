package com.example.eduapp.course.dto;

import com.example.eduapp.course.domain.Course;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public class CourseRequest {

    @Data
    public static class SaveDTO {
        @NotBlank(message = "과정 이름은 필수입니다.")
        private String title;
        private String department;
        private Integer capacity;

        public Course toEntity() {
            return Course.builder()
                    .title(title)
                    .description(department)
                    .capacity(capacity)
                    .build();
        }
    }
}
