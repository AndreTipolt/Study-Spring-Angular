package tipolt.andre.backend.models;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "tb_course")
@Data
public class CourseModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Long id;

    @Column(length = 255, nullable = false)
    @NotNull
    @Length(min = 5, max = 100)
    private String name;

    @Column(length = 10, nullable = false)
    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Back-End|Front-End")
    private String category;
}
