package IBluv2code.ThymeleafApp.service;

import IBluv2code.ThymeleafApp.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(int theId);

    void save(Student theStudent);

    void deleteById(int theId);

}
