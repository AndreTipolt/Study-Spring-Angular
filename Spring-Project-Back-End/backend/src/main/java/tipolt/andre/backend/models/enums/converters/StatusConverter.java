package tipolt.andre.backend.models.enums.converters;
import java.util.stream.Stream;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tipolt.andre.backend.models.enums.StatusEnum;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<StatusEnum, String>{

    @Override
    public String convertToDatabaseColumn(StatusEnum status) {

        if(status == null){
            return null;
        }

        return status.getValue();
    }

    @Override
    public StatusEnum convertToEntityAttribute(String value) {
        
        if(value == null){
            return null;
        }

        return Stream.of(StatusEnum.values()).filter(status -> status.getValue().equals(value)).findFirst().orElseThrow();
    }
    
}