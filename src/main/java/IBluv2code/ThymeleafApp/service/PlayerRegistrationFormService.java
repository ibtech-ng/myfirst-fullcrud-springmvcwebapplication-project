package IBluv2code.ThymeleafApp.service;

import IBluv2code.ThymeleafApp.dao.PlayerRegistrationFormRepository;
import IBluv2code.ThymeleafApp.form.EmployeeRegistrationForm;
import IBluv2code.ThymeleafApp.form.PlayerRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerRegistrationFormService {
    private final PlayerRegistrationFormRepository playerRegistrationFormRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public PlayerRegistrationFormService(PlayerRegistrationFormRepository thePlayerRegistrationFormRepository,BCryptPasswordEncoder thePasswordEncoder){
        this.playerRegistrationFormRepository = thePlayerRegistrationFormRepository;
        this.passwordEncoder = thePasswordEncoder;
    }


    // save the Registration-User to the dB:
    @Transactional
    public  void savePlayerRegistrationForm(PlayerRegistrationForm theForm){

        // Hash the passWord using BCrypt
        String hashedPassword = passwordEncoder.encode(theForm.getPassWord()); //we get the user-password:
        theForm.setPassWord(hashedPassword); // and we turn the user-password to BCrypt-password to the db:

        // Save the form to the database:
        playerRegistrationFormRepository.save(theForm);

    }

    // this method will check if the user input the correct password:
    public boolean authenticatePlayerLogin(String userName, String passWord){

        //this will find the username on the dataBase:
        PlayerRegistrationForm playerRegistrationForm = playerRegistrationFormRepository.findByuserName(userName);

        //Check if the studentRegistrationForm exists and if the provided password matches with the one on the dataBase::
        return playerRegistrationForm !=null && passwordEncoder.matches(passWord,playerRegistrationForm.getPassWord());
    }













}
