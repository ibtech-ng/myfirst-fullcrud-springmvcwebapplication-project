package IBluv2code.ThymeleafApp.dao;

import IBluv2code.ThymeleafApp.form.PlayerRegistrationForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRegistrationFormRepository extends JpaRepository<PlayerRegistrationForm,Integer>{

    PlayerRegistrationForm findByuserName(String userName);
}
