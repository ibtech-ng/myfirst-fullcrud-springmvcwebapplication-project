package IBluv2code.ThymeleafApp.controller;

import IBluv2code.ThymeleafApp.form.EmployeeLogin;
import IBluv2code.ThymeleafApp.form.EmployeeRegistrationForm;
import IBluv2code.ThymeleafApp.service.EmployeeRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/EmployeeLoginController")
public class EmployeeLoginController {


    EmployeeRegistrationService employeeRegistrationService;

    @Autowired
    public EmployeeLoginController(EmployeeRegistrationService theEmployeeRegistrationService){
        this.employeeRegistrationService  = theEmployeeRegistrationService;

    }

    @GetMapping("/showCompanyRegistrationForm")
    public String showCompanyRegistrationForm(Model theModel){

       // create a model attribute for the the Company registration:
      EmployeeRegistrationForm employeeRegistrationForm = new EmployeeRegistrationForm();


     //   this will save the showCompanyRegistrationForm to the db:
     theModel.addAttribute("EmployeeLoginController",employeeRegistrationForm);

     return "employee/employeeregistrationform";

    }

   @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(@ModelAttribute("EmployeeLoginController") EmployeeRegistrationForm theEmployeeRegistrationForm){

        // save the Employee to the db:
       employeeRegistrationService.saveEmployeeRegistrationForm(theEmployeeRegistrationForm);

        // i add it to the "Model-addAttribute", to perform a new page:
       //theModel.addAttribute("StudentController",theStudentRegistrationForm);
       return "employee/registration-success";

   }

   //employeeLogin:
    @GetMapping("/employeeLogin")
    public String employeeLogin(Model theModel){

        // create model attribute for the login:
        EmployeeLogin employeeLogin = new EmployeeLogin();

        // this will save the login form:
        theModel.addAttribute("EmployeeLoginController",employeeLogin);

        return "employee/employeelogin";

    }

    // to process the user Login:
    @PostMapping("/processLogin")
    public String processLogin(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord, Model theModel ){


        // this will check the user-input:
        boolean isAuthenticated = employeeRegistrationService.authenticateEmployeeLogin(userName,passWord);

        // and check if authentication is successful:
        if (isAuthenticated){
            return "employee/employeeprofile";
        }
        else {
            theModel.addAttribute("error", "Invalid Username & Password");
            return "redirect:/EmployeeLoginController/showCompanyRegistrationForm";

        }


    }

}
