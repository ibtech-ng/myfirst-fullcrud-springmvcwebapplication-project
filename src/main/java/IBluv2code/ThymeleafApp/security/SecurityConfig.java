package IBluv2code.ThymeleafApp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {

    /*
    This makes the BCryptPasswordEncoder available as a bean, and you can inject it into other components, such as your service.
    By following these steps, you ensure that the user's password is securely hashed using BCrypt before being stored in the database.
    Additionally, when comparing passwords during authentication, you can use the matches method of BCryptPasswordEncoder.

    */

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
