package tipolt.andre.backend.dtos;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

public record CourseDTO( 
    
    @JsonProperty("_id")
    Long id,

    @NotNull
    @Length(min = 5, max = 100)
    String name,

    @NotNull
    String category
){}

