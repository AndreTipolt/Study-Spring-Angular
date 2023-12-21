package tipolt.andre.backend.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import tipolt.andre.backend.models.CourseModel;
import tipolt.andre.backend.services.CourseService;

@Validated
@RestController
@RequestMapping(value = "/api/course")
@AllArgsConstructor // Ta fazendo a injeção de dependência do courseRepository
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseModel>> list() {
        return ResponseEntity.ok().body(courseService.list());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<CourseModel> create(@RequestBody @Valid CourseModel course) {

        return ResponseEntity.status(201).body(courseService.create(course));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseModel> findById(@PathVariable @NotNull @Positive Long id) {

        CourseModel course = courseService.findById(id);

        return ResponseEntity.ok().body(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseModel> update(@PathVariable @NotNull @Positive Long id,
            @RequestBody @Valid CourseModel courseModel) {

        CourseModel course = courseService.update(id, courseModel);

        return ResponseEntity.ok().body(course);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable @NotNull @Positive Long id) {

         courseService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
