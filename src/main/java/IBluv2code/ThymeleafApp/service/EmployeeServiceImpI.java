package IBluv2code.ThymeleafApp.service;

import IBluv2code.ThymeleafApp.dao.EmployeeRepository;
import IBluv2code.ThymeleafApp.entity.Employee;
import IBluv2code.ThymeleafApp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpI implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpI(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {


        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()){
            theEmployee = result.get();
        }
        else {
            // if we don't have the Employee in db:
            throw  new RuntimeException("Did not find student id - "+theId);
        }
        return theEmployee;

    }


    @Override
    public void save(Employee theEmployee) {
        employeeRepository.save(theEmployee);

    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);

    }
}
