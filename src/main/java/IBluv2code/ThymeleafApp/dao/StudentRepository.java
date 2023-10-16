package IBluv2code.ThymeleafApp.dao;

import IBluv2code.ThymeleafApp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{
}
