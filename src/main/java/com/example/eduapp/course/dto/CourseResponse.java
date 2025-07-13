package com.example.eduapp.course.dto;

import com.example.eduapp.application.domain.Application;
import com.example.eduapp.course.domain.Course;
import lombok.Data;

import java.time.LocalDateTime;

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

    @Data
    public static class CourseApplicantDTO {
        private String name;
        private String department;
        private LocalDateTime appliedAt;

        public CourseApplicantDTO(Application application) {
            this.name = application.getEmployee().getName();
            this.department = application.getEmployee().getDescription();
            this.appliedAt = application.getAppliedAt();
        }
    }
}
