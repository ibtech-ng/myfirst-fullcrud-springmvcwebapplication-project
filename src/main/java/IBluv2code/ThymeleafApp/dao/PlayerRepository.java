package IBluv2code.ThymeleafApp.dao;

import IBluv2code.ThymeleafApp.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Integer>{
}
