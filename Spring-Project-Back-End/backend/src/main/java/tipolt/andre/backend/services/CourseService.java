package tipolt.andre.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tipolt.andre.backend.dtos.CourseDTO;
import tipolt.andre.backend.dtos.mapper.CourseMapper;
import tipolt.andre.backend.exceptions.ResourceNotFoundException;
import tipolt.andre.backend.models.CourseModel;
import tipolt.andre.backend.repositories.CourseRepository;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    private CourseMapper courseMapper;

    public List<CourseDTO> list() {
        return courseRepository.findAll().stream().map((course) -> courseMapper.toDTO(course)).toList();
    }

    public CourseDTO create(CourseDTO course) {

        CourseModel courseModel = courseMapper.toCourseModel(course);

        courseRepository.save(courseModel);
        return course;
    }

    public CourseDTO findById(Long id) {

        CourseModel course =  courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        return courseMapper.toDTO(course);
    }

    public CourseDTO update(Long id, CourseDTO courseModel) {

        CourseModel objectThatWillBeUpdated = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        objectThatWillBeUpdated.setCategory(courseMapper.convertCategoryValue(courseModel.category()));
        objectThatWillBeUpdated.setName(courseModel.name());

        courseRepository.save(objectThatWillBeUpdated);

        return courseModel;
    }

    public void delete(Long id) {

        CourseModel objectToWillBeRemoved = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        courseRepository.deleteById(objectToWillBeRemoved.getId());

        return;
    }
}
