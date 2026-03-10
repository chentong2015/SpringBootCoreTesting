package spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Will only be loaded when devConfig=production in .properties file
@Configuration
@ConditionalOnProperty(value="devConfig", havingValue="test")
public class MyPropertyConfig {

    @Value("${custom.property.name:default-value}")
    private String propertyValue;

    @Bean
    public PropertyConditionClass propertyConditionClass() {
        System.out.println("Get property name: " + propertyValue);
        return new PropertyConditionClass();
    }

    public static class PropertyConditionClass {
        public PropertyConditionClass() {}

        public void print() {
            System.out.println("print PropertyConditionClass");
        }
    }
}
