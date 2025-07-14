package com.example.eduapp.application;

import com.example.eduapp._core.utils.Resp;
import com.example.eduapp.application.dto.ApplicationRequest;
import com.example.eduapp.application.dto.ApplicationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    // MTCD: valid 체크 필요
    @PostMapping("/applications")
    public ResponseEntity<?> save(@RequestBody ApplicationRequest.SaveDTO reqDTO) {
        ApplicationResponse.SaveDTO resqDTO = applicationService.save(reqDTO);
        return Resp.ok(resqDTO);
    }

}
