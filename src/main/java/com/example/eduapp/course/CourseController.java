package com.example.eduapp.course;

import com.example.eduapp._core.utils.Resp;
import com.example.eduapp.course.dto.CourseRequest;
import com.example.eduapp.course.dto.CourseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/courses")
    public ResponseEntity<?> save(@Valid @RequestBody CourseRequest.SaveDTO reqDTO, Errors errors) {
        CourseResponse.SaveDTO respDTO = courseService.save(reqDTO);
        return Resp.ok(respDTO);
    }

    @GetMapping("/courses/{id}/applicants")
    private ResponseEntity<?> getApplicants(@PathVariable int id) {
        List<CourseResponse.CourseApplicantDTO> resqDTO = courseService.getApplicants(id);
        return Resp.ok(resqDTO);
    }
}
