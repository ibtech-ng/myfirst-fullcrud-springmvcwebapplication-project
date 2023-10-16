package IBluv2code.ThymeleafApp.controller;

import IBluv2code.ThymeleafApp.form.PlayerLogin;
import IBluv2code.ThymeleafApp.form.PlayerRegistrationForm;
import IBluv2code.ThymeleafApp.service.PlayerRegistrationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/PlayerLoginController")
public class PlayerLoginController {
    private PlayerRegistrationFormService playerRegistrationFormService;

    @Autowired
    public PlayerLoginController(PlayerRegistrationFormService thePlayerRegistrationFormService){
        this.playerRegistrationFormService = thePlayerRegistrationFormService;
    }

    @GetMapping("/showPlayerRegistrationForm")
    public String showPlayerRegistrationForm (Model theModel){

        // create the players form to bind the data:
        PlayerRegistrationForm playerRegistrationForm = new PlayerRegistrationForm();

        // bind the data:
        theModel.addAttribute("players",playerRegistrationForm);

        return "players/playerregistrationform";
    }


    // controller processRegistrationForm:
    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm (@ModelAttribute("players") PlayerRegistrationForm playerRegistrationForm){

        // save the Employee to the db:
        playerRegistrationFormService.savePlayerRegistrationForm(playerRegistrationForm);

        // return the form-for-login:
        return "players/registration-success";
    }

    // player-login:
    @GetMapping("/playerLogin")
    public String playerLogin(Model theModel){

        // create model attribute for the login:
        PlayerLogin playerLogin = new PlayerLogin();

        // this will save the login form:
        theModel.addAttribute("players" , playerLogin);

        return "players/playerlogin";
    }

    //processLogin
    @PostMapping("/processLogin")
    public String processLogin(@RequestParam("userName") String userName , @RequestParam("passWord") String passWord, Model theModel){

        // this will check the user-input:
        boolean isAuthenticated = playerRegistrationFormService.authenticatePlayerLogin(userName,passWord);

        // and check if authentication is successful:
        if (isAuthenticated){
            return "players/playerprofile";
        }
        else {
            theModel.addAttribute("error", "Invalid Username & Password");
            return "redirect:/PlayerLoginController/showPlayerRegistrationForm";
        }


    }
}
