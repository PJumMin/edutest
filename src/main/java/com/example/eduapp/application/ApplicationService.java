package com.example.eduapp.application;

import com.example.eduapp.application.domain.Application;
import com.example.eduapp.application.dto.ApplicationRequest;
import com.example.eduapp.application.dto.ApplicationResponse;
import com.example.eduapp.application.repository.ApplicationRepository;
import com.example.eduapp.course.domain.Course;
import com.example.eduapp.course.repository.CourseRepository;
import com.example.eduapp.employee.domain.Employee;
import com.example.eduapp.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    @Transactional
    public ApplicationResponse.SaveDTO save(ApplicationRequest.SaveDTO reqDTO) {
        Employee employeePS = employeeRepository.findById(reqDTO.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("직원을 찾을 수 없습니다"));

        Course CoursePS = courseRepository.findById(reqDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException("코스를 찾을 수 없습니다"));

        Application savePS = applicationRepository.save(reqDTO.toEntity(employeePS, CoursePS));

        return new ApplicationResponse.SaveDTO(savePS.getEmployee().getId(), savePS.getCourse().getId());
    }
}
