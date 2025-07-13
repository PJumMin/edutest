package com.example.eduapp.course.dto;

import com.example.eduapp.course.domain.Course;
import lombok.Data;

public class CourseResponse {

    @Data
    public static class SaveDTO {
        private String title;
        private String department;
        private Integer capacity;

        public SaveDTO(Course course) {
            this.title = course.getTitle();
            this.department = course.getDescription();
            this.capacity = course.getCapacity();
        }
    }
}
