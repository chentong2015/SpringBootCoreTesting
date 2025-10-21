package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO. Spring Context 容器的配置
@Configuration
public class IncludeContextConfig {

    @Bean
    public IncludedBean includedBean() {
        return new IncludedBean();
    }

    public static class IncludedBean {

        public IncludedBean() {}

        public void print() {
            System.out.println("Hello test bean");
        }
    }
}
