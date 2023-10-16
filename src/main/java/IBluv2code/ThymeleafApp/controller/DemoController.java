package IBluv2code.ThymeleafApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class DemoController {
// let develop the mvc controller:
// MVC =Model-view-controller:
    @GetMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theDate",new java.util.Date());
        return "helloworld";
    }
    // so here<= we have Thymeleaf dependency in Maven POM:
    // spring Boot will auto-configure to use Thymeleaf:
}
