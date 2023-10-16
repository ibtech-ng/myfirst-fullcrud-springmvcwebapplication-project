package IBluv2code.ThymeleafApp.dao;

import IBluv2code.ThymeleafApp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Integer>{
}
