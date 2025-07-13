package com.example.eduapp.course;

import com.example.eduapp.application.domain.Application;
import com.example.eduapp.application.repository.ApplicationRepository;
import com.example.eduapp.course.domain.Course;
import com.example.eduapp.course.dto.CourseRequest;
import com.example.eduapp.course.dto.CourseResponse;
import com.example.eduapp.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final ApplicationRepository applicationRepository;

    @Transactional
    public CourseResponse.SaveDTO save(CourseRequest.SaveDTO reqDTO) {
        Course savePS = courseRepository.save(reqDTO.toEntity());
        return new CourseResponse.SaveDTO(savePS);
    }

    public List<CourseResponse.CourseApplicantDTO> getApplicants(int id) {
        List<Application> courseList = applicationRepository.findByCourseId(id);
        List<CourseResponse.CourseApplicantDTO> applicationList = new ArrayList<>();
        for (Application applications : courseList) {
            applicationList.add(new CourseResponse.CourseApplicantDTO(applications));
        }

        return applicationList;
    }
}
