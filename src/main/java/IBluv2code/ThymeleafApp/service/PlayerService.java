package IBluv2code.ThymeleafApp.service;

import IBluv2code.ThymeleafApp.entity.Player;

import java.util.List;

public interface PlayerService {
    List<Player> findAll();

    Player findById(int theId);

    void save(Player thePlayer);

    void deleteById(int theId);
}
