package ch.lalumash.ToBeHacked.beans;


import ch.lalumash.ToBeHacked.manager.LoginManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Beans {
    @Bean
    @Scope("singleton")
    public LoginManager loginManager() {
        return new LoginManager();
    }
}
