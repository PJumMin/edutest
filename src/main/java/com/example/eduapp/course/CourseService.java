package com.example.eduapp.course;

import com.example.eduapp._core.error.ex.ExceptionApi400;
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
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final ApplicationRepository applicationRepository;

    @Transactional
    public CourseResponse.SaveDTO save(CourseRequest.SaveDTO reqDTO) {
        Optional<Course> courseOptional = courseRepository.findByTitle(reqDTO.getTitle());

        if (courseOptional.isPresent()) {
            throw new ExceptionApi400("이미 있는 과목입니다.");
        }

        Course savePS = courseRepository.save(reqDTO.toEntity());
        return new CourseResponse.SaveDTO(savePS);
    }

    public List<CourseResponse.CourseApplicantDTO> getApplicants(Long id) {
        List<Application> applicationList = applicationRepository.findByCourseId(id);
        List<CourseResponse.CourseApplicantDTO> responseList = new ArrayList<>();
        for (Application application : applicationList) {
            responseList.add(new CourseResponse.CourseApplicantDTO(application));
        }

        return responseList;
    }
}
