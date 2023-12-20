package tipolt.andre.backend.controllers;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tipolt.andre.backend.models.CourseModel;
import tipolt.andre.backend.repositories.CourseRepository;

@RestController
@RequestMapping(value = "/api/course")
@AllArgsConstructor // Ta fazendo a injeção de dependência do courseRepository
public class CourseController {

    private final CourseRepository courseRepository;

    @GetMapping
    public List<CourseModel> list(){
        return courseRepository.findAll();
    }

}
