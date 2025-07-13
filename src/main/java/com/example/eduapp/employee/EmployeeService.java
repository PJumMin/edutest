package com.example.eduapp.employee;

import com.example.eduapp._core.error.ex.ExceptionApi400;
import com.example.eduapp.application.domain.Application;
import com.example.eduapp.application.repository.ApplicationRepository;
import com.example.eduapp.employee.domain.Employee;
import com.example.eduapp.employee.dto.EmployeeRequest;
import com.example.eduapp.employee.dto.EmployeeResponse;
import com.example.eduapp.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ApplicationRepository applicationRepository;

    @Transactional
    public EmployeeResponse.SaveDTO save(EmployeeRequest.SaveDTO reqDTO) {
        Optional<Employee> employeeOptional = employeeRepository.findByEmail(reqDTO.getEmail());

        if (employeeOptional.isPresent()) {
            throw new ExceptionApi400("이미 사용 중인 이메일입니다.");
        }

        Employee savePS = employeeRepository.save(reqDTO.toEntity());
        return new EmployeeResponse.SaveDTO(savePS);
    }

    public List<EmployeeResponse.EmployeeApplicantDTO> getApplicants(Long id) {
        List<Application> employeeList = applicationRepository.findByEmployeeId(id);
        List<EmployeeResponse.EmployeeApplicantDTO> applicationList = new ArrayList<>();
        for (Application employees : employeeList) {
            applicationList.add(new EmployeeResponse.EmployeeApplicantDTO(employees));
        }

        return applicationList;
    }

}
