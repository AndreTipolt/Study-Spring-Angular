package tipolt.andre.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tipolt.andre.backend.models.CourseModel;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Long>{
    
}
