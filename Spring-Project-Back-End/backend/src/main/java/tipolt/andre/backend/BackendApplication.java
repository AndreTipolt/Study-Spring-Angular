package tipolt.andre.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tipolt.andre.backend.models.CourseModel;
import tipolt.andre.backend.repositories.CourseRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
    CommandLineRunner initDatabase(CourseRepository courseRepository){ // Command Line Runner serve pra quando a aplicação subir ele ja executar

        return args -> {

            courseRepository.findAll();

			CourseModel newCourse = new CourseModel();

			newCourse.setName("Curso de Java");
			newCourse.setCategory("Back-End");

			courseRepository.save(newCourse);
        };
    }
}
