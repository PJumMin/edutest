package com.example.eduapp.course;

import com.example.eduapp.course.domain.Course;
import com.example.eduapp.course.dto.CourseRequest;
import com.example.eduapp.course.dto.CourseResponse;
import com.example.eduapp.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    @Transactional
    public CourseResponse.SaveDTO save(CourseRequest.SaveDTO reqDTO) {
        Course savePS = courseRepository.save(reqDTO.toEntity());
        return new CourseResponse.SaveDTO(savePS);
    }
}
