package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// This special configuration should be removed during testing
@Configuration
public class ExcludedContextConfig {

    @Bean
    public ExcludedBean excludedBean() {
        return new ExcludedBean();
    }

    public static class ExcludedBean {
        public ExcludedBean() {}

        public void print() {
            System.out.println("print ExcludedClass");
        }
    }
}
