package tipolt.andre.backend.dtos.mapper;

import org.springframework.stereotype.Component;

import tipolt.andre.backend.dtos.CourseDTO;
import tipolt.andre.backend.models.CourseModel;
import tipolt.andre.backend.models.enums.CategoryEnum;

@Component
public class CourseMapper {
    
    public CourseDTO toDTO(CourseModel courseModel){
        return new CourseDTO(courseModel.getId(), courseModel.getName(), courseModel.getCategory().getValue());
    }

    public CourseModel toCourseModel(CourseDTO courseDTO){

        CourseModel courseModel = new CourseModel();

        if(courseDTO.id() != null){

            courseModel.setId(courseDTO.id());
        }
        courseModel.setName(courseDTO.name());
        courseModel.setCategory(convertCategoryValue(courseDTO.category()));

        return courseModel;
    }

    public CategoryEnum convertCategoryValue(String value){
        if(value == null){
            return null;
        }

        return switch (value) {
            case "Front-End"-> CategoryEnum.FRONT_END;

            case "Back-End" -> CategoryEnum.BACK_END;

            default -> throw new IllegalArgumentException("Invalid Category");
        };
    }
}
