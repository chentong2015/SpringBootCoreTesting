package spring.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Will only be loaded when there is devConfig: production in .properties file
@Configuration
@ConditionalOnProperty(value="devConfig", havingValue="production")
public class MyPropertyConfig {

    @Bean
    public PropertyConditionClass propertyConditionClass() {
        return new PropertyConditionClass();
    }

    public static class PropertyConditionClass {
        public PropertyConditionClass() {}

        public void print() {
            System.out.println("print PropertyConditionClass");
        }
    }
}
