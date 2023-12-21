package tipolt.andre.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tipolt.andre.backend.models.CourseModel;
import tipolt.andre.backend.repositories.CourseRepository;

@Service
@AllArgsConstructor
public class CourseService {
    
    private final CourseRepository courseRepository;

    public List<CourseModel> list() {
        return courseRepository.findAll();
    }

    public CourseModel create(CourseModel course) {

        return courseRepository.save(course);
    }

    public CourseModel findById(Long id) {

        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public CourseModel update(Long id,CourseModel courseModel) {


        CourseModel objectThatWillBeUpdated = courseRepository.findById(id).orElseThrow(() -> new RuntimeException());

        objectThatWillBeUpdated.setCategory(courseModel.getCategory());
        objectThatWillBeUpdated.setName(courseModel.getName());

        CourseModel updated = courseRepository.save(objectThatWillBeUpdated);
        
        return updated;
    }

    public void delete(Long id){

        CourseModel objectToWillBeRemoved = courseRepository.findById(id).orElseThrow(() -> new RuntimeException());

        courseRepository.deleteById(objectToWillBeRemoved.getId());

        return;
    }
}
