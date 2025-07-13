package com.example.eduapp.course;

import com.example.eduapp._core.utils.Resp;
import com.example.eduapp.course.dto.CourseRequest;
import com.example.eduapp.course.dto.CourseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/courses")
    public ResponseEntity<?> save(@RequestBody CourseRequest.SaveDTO reqDTO) {
        CourseResponse.SaveDTO respDTO = courseService.save(reqDTO);
        return Resp.ok(respDTO);
    }
}
