package tipolt.andre.backend.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public List<CourseModel> list() {
        return courseRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CourseModel create(@RequestBody CourseModel course) {

        return courseRepository.save(course);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseModel> findById(@PathVariable Long id) {

        return courseRepository.findById(id).map((record) -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
}
