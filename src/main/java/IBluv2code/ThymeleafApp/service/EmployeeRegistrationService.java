package IBluv2code.ThymeleafApp.service;

import IBluv2code.ThymeleafApp.dao.EmployeeRegistrationFormRepository;
import IBluv2code.ThymeleafApp.form.EmployeeRegistrationForm;
import IBluv2code.ThymeleafApp.form.StudentRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeRegistrationService {
    private final EmployeeRegistrationFormRepository employeeRegistrationFormRepository;

    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public EmployeeRegistrationService(EmployeeRegistrationFormRepository theEmployeeRegistrationFormRepository, BCryptPasswordEncoder thePasswordEncoder){
        this.employeeRegistrationFormRepository = theEmployeeRegistrationFormRepository;
        this.passwordEncoder = thePasswordEncoder;
    }

    // save the employee to the db:
    @Transactional
    public  void saveEmployeeRegistrationForm(EmployeeRegistrationForm theForm){

        // Hash the password using BCrypt:
        String  hashedPassword = passwordEncoder.encode(theForm.getPassWord()); //we get the user-password:
        theForm.setPassWord(hashedPassword); // and we turn the user-password to BCrypt-password:

        // Save the form to the database:
        employeeRegistrationFormRepository.save(theForm);

    }


     // this method will check if the user input the correct password:
    @Transactional
      public  boolean authenticateEmployeeLogin(String userName, String passWord){

        //this will find the username on the dataBase:
        EmployeeRegistrationForm  employeeRegistrationForm = employeeRegistrationFormRepository.findByuserName(userName);

        //Check if the studentRegistrationForm exists and if the provided password matches with the one on the dataBase::
        return employeeRegistrationForm != null && passwordEncoder.matches(passWord,employeeRegistrationForm.getPassWord());
    }

}
