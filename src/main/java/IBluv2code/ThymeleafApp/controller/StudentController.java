package IBluv2code.ThymeleafApp.controller;

import IBluv2code.ThymeleafApp.dao.StudentRegistrationFormRepository;
import IBluv2code.ThymeleafApp.entity.Student;
import IBluv2code.ThymeleafApp.form.StudentLogin;
import IBluv2code.ThymeleafApp.form.StudentRegistrationForm;
import IBluv2code.ThymeleafApp.profile.Profile;
import IBluv2code.ThymeleafApp.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/StudentController")
public class StudentController {

    //this controller is to check for:
    // for the Registration-form and login-form:

    private StudentRegistrationService studentRegistrationService;

       // inject it to the Constructor:
    @Autowired
    public StudentController(StudentRegistrationService theStudentRegistrationService){
        studentRegistrationService = theStudentRegistrationService;

    }



    // end-point for the Home-Page:
    @GetMapping("/home")
    public String home() {
        return "home"; // This corresponds to the name of your HTML file (without the extension)
    }

    // end-point for Student-Directory:



    // end-point for the Student-RegistrationForm:
   @GetMapping("/showRegistrationForm")
    public String showRegistrationForm(Model theModel) {

//       // create model attribute to link to the dataBase:
       StudentRegistrationForm theStudentRegistrationForm = new StudentRegistrationForm();

//       // this will save the showRegistrationForm to dataBase:
      theModel.addAttribute("StudentController",theStudentRegistrationForm);

        return "register";
    }

    //processRegistration:
    @PostMapping("/processRegistrationForm")
    public String studentDirectory( @ModelAttribute("StudentController") StudentRegistrationForm theStudentRegistrationForm ){

        // save the showRegistrationForm to the dataBase:
        studentRegistrationService.saveStudentRegistrationForm(theStudentRegistrationForm);


        // i add it to the "Model-addAttribute", to perform a new page:
        //theModel.addAttribute("StudentController",theStudentRegistrationForm);

        return"registration-success";

    }


     //end-point for login-Student:
    @GetMapping("/studentLogin")
    public String studentLogin(Model theModel){
        // create model attribute to link to the dataBase:
        StudentLogin theStudentLogin = new StudentLogin();

        // this will save the login form:
        theModel.addAttribute("StudentController",theStudentLogin);


        return "studentlogin";
    }

    // login-process:
    @PostMapping("/processLogin")
    public  String processLogin(@RequestParam("userName") String userName, @RequestParam("password") String passWord, Model theModel){

        // Authenticate the studentLogin, this will check what the student-Input:
        boolean isAuthenticated = studentRegistrationService.authenticateStudentLogin(userName,passWord);

        // and Check if authentication is successful:
        if (isAuthenticated){
            return "studentprofile";
        }
        else {
            theModel.addAttribute("error", "Invalid Username & Password");
            return "redirect:/StudentController/showRegistrationForm";
        }

    }

    // FOR THE PROFILE
//    @PostMapping("/StudentController/{studentId}/register")
//    public void  createProfile(@PathVariable int studentId, @RequestBody Profile profile){
//        studentRegistrationService.createProfile(studentId,profile);
//    }
//
//    @GetMapping("/StudentController/{studentId}/registration-success")
//    public Profile getProfile(@PathVariable int studentId){
//        return studentRegistrationService.getProfile(studentId);
//
//    }










}
