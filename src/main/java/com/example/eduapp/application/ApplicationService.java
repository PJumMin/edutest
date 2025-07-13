package com.example.eduapp.application;

import com.example.eduapp.application.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository employeeRepository;

}
