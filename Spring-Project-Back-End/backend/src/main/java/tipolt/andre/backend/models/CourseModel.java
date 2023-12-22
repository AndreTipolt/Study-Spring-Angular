package tipolt.andre.backend.models;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import tipolt.andre.backend.models.enums.CategoryEnum;
import tipolt.andre.backend.models.enums.StatusEnum;
import tipolt.andre.backend.models.enums.converters.CategoryConverter;
import tipolt.andre.backend.models.enums.converters.StatusConverter;

@Entity
@Table(name = "tb_course")
@Data
@SQLDelete(sql = "UPDATE tb_course SET status = 'Inativo' WHERE id = ?") // Toda vez que ele executar o delete ele vai
                                                                         // executar esse bloco de codigo
@Where(clause = "status = 'Ativo'") // Toda vez que for fazer um select ele vai fazer esse where
public class CourseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Convert(converter = CategoryConverter.class)
    private CategoryEnum category;

    @Convert(converter = StatusConverter.class)
    private StatusEnum status = StatusEnum.ACTIVATE;
}
