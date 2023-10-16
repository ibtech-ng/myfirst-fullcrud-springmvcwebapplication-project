package IBluv2code.ThymeleafApp.service;

import IBluv2code.ThymeleafApp.dao.StudentRegistrationFormRepository;
import IBluv2code.ThymeleafApp.form.StudentRegistrationForm;
import IBluv2code.ThymeleafApp.profile.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentRegistrationService {
    private final StudentRegistrationFormRepository studentRegistrationFormRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    // i inject the "StudentRegistrationFormRepository" and the "BCryptPasswordEncoder":
    @Autowired
    public StudentRegistrationService(StudentRegistrationFormRepository theStudentRegistrationFormRepository,BCryptPasswordEncoder thePasswordEncoder){
        this.studentRegistrationFormRepository = theStudentRegistrationFormRepository;
        this.passwordEncoder =thePasswordEncoder;
    }

    // save RegistrationForm method:
    @Transactional
    public void saveStudentRegistrationForm (StudentRegistrationForm form){

        // Hash the password using BCrypt:
        String hashedPassword = passwordEncoder.encode(form.getPassWord()); //we get the user-password:
        form.setPassWord(hashedPassword); // and we turn it to BCrypt-password.

        // Save the form to the database:
       studentRegistrationFormRepository.save(form);
    }



    // method to check if the user-input:
    // the same username and password that is:
    // store in the Db:
    @Transactional
    public boolean  authenticateStudentLogin(String userName,String passWord){

         // Retrieve the studentRegistrationForm by username:, this will find the username on the dataBase:
        StudentRegistrationForm studentRegistrationForm = studentRegistrationFormRepository.findByuserName(userName);

        //Check if the studentRegistrationForm exists and if the provided password matches with the one on the dataBase::
        return studentRegistrationForm != null && passwordEncoder.matches(passWord,studentRegistrationForm.getPassWord());

    }















}
