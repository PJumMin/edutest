package com.example.eduapp;

import com.example.eduapp.domain.Employee;
import com.example.eduapp.dto.EmployeeRequest;
import com.example.eduapp.dto.EmployeeResponse;
import com.example.eduapp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeResponse.SaveDTO save(EmployeeRequest.SaveDTO reqDTO) {
        Employee savePS = employeeRepository.save(reqDTO.toEntity());
        return new EmployeeResponse.SaveDTO(savePS);
    }
}
