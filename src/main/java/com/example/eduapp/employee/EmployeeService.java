package com.example.eduapp.employee;

import com.example.eduapp.employee.domain.Employee;
import com.example.eduapp.employee.dto.EmployeeRequest;
import com.example.eduapp.employee.dto.EmployeeResponse;
import com.example.eduapp.employee.repository.EmployeeRepository;
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
