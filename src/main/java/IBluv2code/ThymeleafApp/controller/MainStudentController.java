package IBluv2code.ThymeleafApp.controller;

import IBluv2code.ThymeleafApp.entity.Student;
import IBluv2code.ThymeleafApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/MainStudentController")
public class MainStudentController {

    private StudentService studentService;

    @Autowired
    public MainStudentController(StudentService theStudentService){
      this.studentService = theStudentService;
    }

    @GetMapping("/list")
    public String StudentList(Model theModel){

        // get the student from the db:
        List<Student> theStudent = studentService.findAll();

        // add it to Spring model:
        theModel.addAttribute("MainStudentController", theStudent);

        return "studentprofile";


    }

    //showStudentFormForAdd:
    @GetMapping("/showStudentFormForAdd")
    public String showStudentFormForAdd(Model theModel){

        // create a model attribute to bind the data:
        Student theStudent = new Student();

        // add the new student to the dataBase:
        theModel.addAttribute("MainStudentController",theStudent);

        //
        return "student/studentupdateform";

    }


    // controller for update:
    @GetMapping("/showStudentFormForUpdate")
    public String showStudentFormForUpdate( @RequestParam("studentId") int theId, Model theModel){

        // get the student from the service:
        Student theStudent = studentService.findById(theId);


        // add the student to the db:
        theModel.addAttribute("MainStudentController", theStudent);

        // this will take them to the student-form:
        return "student/studentupdateform";
    }

    // saveFormUpdate:
    @PostMapping("/save")
    public String saveFormUpdate(@ModelAttribute("MainStudentController") Student theStudent){

        // save the student:
        studentService.save(theStudent);

        // this will just take you to the student-profile, once you save:
        return "redirect:/MainStudentController/list";

    }

    //controller to delete:
    @GetMapping("/delete")
    public String delete(@RequestParam ("studentId") int theId ){

        // delete the student:
        studentService.deleteById(theId);

         // redirect to the /student/list:
        return "redirect:/MainStudentController/list";


    }

}
