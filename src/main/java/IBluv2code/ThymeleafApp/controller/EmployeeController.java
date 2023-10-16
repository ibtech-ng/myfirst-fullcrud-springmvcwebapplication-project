package IBluv2code.ThymeleafApp.controller;

import IBluv2code.ThymeleafApp.entity.Employee;
import IBluv2code.ThymeleafApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employeeController")
public class EmployeeController {

    private EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //list:
    @GetMapping("/list")
    public String employeeList (Model theModel){

        // get the saved employee from the db:
        List<Employee> theEmployee = employeeService.findAll();

        //add it to Spring model, so we can have new page:
        theModel.addAttribute("employeeController",theEmployee);

        return "employee/employeeprofile";

    }


    //showEmployeeFormForAdd:
    @GetMapping("/showEmployeeFormForAdd")
    public String showStudentFormForAdd (Model theModel){

         // create a model attribute to bind the data:
         Employee theEmployee = new Employee();

         //add the new student to the dataBase:
         theModel.addAttribute("employeeController",theEmployee);

        return "employee/employeeupdateform";

    }

    // controller for update:
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId , Model theModel){

        // get the employee from the service:
        Employee theEmployee = employeeService.findById(theId);

        // set employee in the model to prepopulate the form:
        theModel.addAttribute("employeeController", theEmployee);

        // send over to our form:
        return "employee/employeeupdateform";
    }


    // controller to save:
    @PostMapping("/save")
    public String saveEmployee( @ModelAttribute ("employeeController") Employee theEmployee ){

        // save the employee:
        employeeService.save(theEmployee);

        return "redirect:/employeeController/list";
    }

    // controller to delete:
    @GetMapping("/delete")
    public String delete(@RequestParam ("EmployeeId") int theId){

        // delete the employee:
        employeeService.deleteById(theId);

        return "redirect:/employeeController/list";

    }



}
