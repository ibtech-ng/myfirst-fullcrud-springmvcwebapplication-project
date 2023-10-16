package IBluv2code.ThymeleafApp.controller;

import IBluv2code.ThymeleafApp.entity.Player;
import IBluv2code.ThymeleafApp.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/playerController")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService thePlayerService){
       this.playerService = thePlayerService;
    }


    @GetMapping("/list")
    public String playerList (Model theModel){
        List<Player> thePlayers = playerService.findAll();

        theModel.addAttribute("players",thePlayers);

        return "players/playerprofile";
    }

    @GetMapping("/showFormForAdd")
    public String showPlayerFormForAdd (Model theModel){

        Player thePlayer = new Player();

        theModel.addAttribute("players", thePlayer);

        return "players/playerupdateform";
    }

    @GetMapping("/showFormForUpdate")
    public String showPlayerFormForUpdate(@RequestParam("playerId") int theId, Model theModel ){

        Player thePlayer = playerService.findById(theId);

        theModel.addAttribute("players", thePlayer);

        return "players/playerupdateform";

    }

   @PostMapping("/save")
    public  String savePlayers(@ModelAttribute("players") Player thePlayer){

        playerService.save(thePlayer);

        return "redirect:/playerController/list";
   }

   @GetMapping("/delete")
    public String delete(@RequestParam("playerId") int theId){

        playerService.deleteById(theId);

       return "redirect:/playerController/list";

   }



}
