package com.example.eduapp.employee;

import com.example.eduapp._core.utils.Resp;
import com.example.eduapp.employee.dto.EmployeeRequest;
import com.example.eduapp.employee.dto.EmployeeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public ResponseEntity<?> save(@Valid @RequestBody EmployeeRequest.SaveDTO reqDTO, Errors errors) {
        EmployeeResponse.SaveDTO respDTO = employeeService.save(reqDTO);
        return Resp.ok(respDTO);
    }

    @GetMapping("/employees/{id}/applications")
    public ResponseEntity<?> getApplicants(@PathVariable Long id) {
        List<EmployeeResponse.EmployeeApplicantDTO> respDTO = employeeService.getApplicants(id);
        return Resp.ok(respDTO);

    }
}
