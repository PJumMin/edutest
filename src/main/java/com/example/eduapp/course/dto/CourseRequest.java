package com.example.eduapp.course.dto;

import com.example.eduapp.course.domain.Course;
import lombok.Data;

public class CourseRequest {

    @Data
    public static class SaveDTO {
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
