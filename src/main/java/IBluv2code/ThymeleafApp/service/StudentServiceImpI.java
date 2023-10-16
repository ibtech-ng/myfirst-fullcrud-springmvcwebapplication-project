package IBluv2code.ThymeleafApp.service;

import IBluv2code.ThymeleafApp.dao.StudentRepository;
import IBluv2code.ThymeleafApp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpI implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpI(StudentRepository theStudentRepository){
        this.studentRepository = theStudentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int theId) {
        Optional<Student> result = studentRepository.findById(theId);

        Student theStudent = null;

        if (result.isPresent()){
            theStudent = result.get();
        }
        else {
            // if we don't have student in db:
            throw  new RuntimeException("Did not find student id - " + theId);
        }
        return theStudent;
    }

    @Override
    public void save(Student theStudent) {
        studentRepository.save(theStudent);
    }

    @Override
    public void deleteById(int theId) {
        studentRepository.deleteById(theId);

    }
}
