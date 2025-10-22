package spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spring.injection.BeanLifecycle;
import spring.injection.BeanProperty;

@SpringBootApplication
public class SpringBootTestingApplication {

    public static void main(String[] args) {
        System.out.println("Start application");
        SpringApplication.run(SpringBootTestingApplication.class, args);
    }

    // TODO. 在测试时如果将BeanLifecycle对象Mock掉, 启动时会使用Mock对象
    //  由于Mock对象属性为Null导致Spring容器无法正常启动 => 必须对属性做非Null判断
    @Bean
    public CommandLineRunner eventDescriptorRunner(BeanLifecycle beanLifecycle) {
        return args -> {
            BeanProperty bp = beanLifecycle.getBeanProperty();
            System.out.println(bp.getNumber());
        };
    }
}