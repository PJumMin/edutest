package com.example.eduapp;

import com.example.eduapp._core.utils.Resp;
import com.example.eduapp.dto.EmployeeRequest;
import com.example.eduapp.dto.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<?> save(@RequestBody EmployeeRequest.SaveDTO reqDTO) {
        EmployeeResponse.SaveDTO respDTO = employeeService.save(reqDTO);
        return Resp.ok(respDTO);
    }
}
