package tipolt.andre.backend.models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
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
@SQLDelete(sql="UPDATE tb_course SET status = 'Inativo' WHERE id = ?") // Toda vez que ele executar o delete ele vai executar esse bloco de codigo
@Where(clause = "status = 'Active'") // Toda vez que for fazer um select ele vai fazer esse where
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

    @Column(length = 10, nullable = false)
    @NotNull
    @Length(max = 10)
    @Pattern(regexp = "Active|Inactive")
    private String status = "Active";
}
