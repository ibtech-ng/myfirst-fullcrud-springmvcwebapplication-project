package IBluv2code.ThymeleafApp.service;

import IBluv2code.ThymeleafApp.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteById(int theId);
}
