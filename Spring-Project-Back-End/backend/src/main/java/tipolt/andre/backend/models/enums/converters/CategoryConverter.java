package tipolt.andre.backend.models.enums.converters;

import java.util.stream.Stream;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tipolt.andre.backend.models.enums.CategoryEnum;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<CategoryEnum, String>{

    @Override
    public String convertToDatabaseColumn(CategoryEnum category) {

        if(category == null){
            return null;
        }

        return category.getValue();
    }

    @Override
    public CategoryEnum convertToEntityAttribute(String value) {
        
        if(value == null){
            return null;
        }

        return Stream.of(CategoryEnum.values()).filter(category -> category.getValue().equals(value)).findFirst().orElseThrow();
    }
    
}
