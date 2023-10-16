package IBluv2code.ThymeleafApp.service;

import IBluv2code.ThymeleafApp.dao.PlayerRepository;
import IBluv2code.ThymeleafApp.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpI implements PlayerService{

    private PlayerRepository playerRepository;
    @Autowired
    public PlayerServiceImpI (PlayerRepository thePlayerRepository){
        this.playerRepository = thePlayerRepository;
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player findById(int theId) {

        Optional<Player> result = playerRepository.findById(theId);

        Player thePlayer = null;

        if (result.isPresent()){
            thePlayer = result.get();
        }
        else {
            // if we don't have the players in db:
            throw  new RuntimeException("Did not find the player-Id "+theId);
        }
        return thePlayer;

    }

    @Override
    public void save(Player thePlayer) {
        playerRepository.save(thePlayer);

    }

    @Override
    public void deleteById(int theId) {
        playerRepository.deleteById(theId);
    }


}
