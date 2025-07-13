package com.example.eduapp.employee;

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

@Repository
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ApplicationRepository applicationRepository;

    @Transactional
    public EmployeeResponse.SaveDTO save(EmployeeRequest.SaveDTO reqDTO) {
        Employee savePS = employeeRepository.save(reqDTO.toEntity());
        return new EmployeeResponse.SaveDTO(savePS);
    }

    public List<EmployeeResponse.EmployeeApplicantDTO> getApplicants(int id) {
        List<Application> employeeList = applicationRepository.findByEmployeeId(id);
        List<EmployeeResponse.EmployeeApplicantDTO> applicationList = new ArrayList<>();
        for (Application employees : employeeList) {
            applicationList.add(new EmployeeResponse.EmployeeApplicantDTO(employees));
        }

        return applicationList;
    }

}
