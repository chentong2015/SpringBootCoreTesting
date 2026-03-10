package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// Will only be loaded when spring.profiles.active=dev
@Configuration
@Profile("dev")
public class MyProfileConfig {

    @Bean
    public ProfileClass profileClass() {
        return new ProfileClass();
    }

    public static class ProfileClass {
        public ProfileClass() {}

        public void print() {
            System.out.println("print profile class");
        }
    }
}
