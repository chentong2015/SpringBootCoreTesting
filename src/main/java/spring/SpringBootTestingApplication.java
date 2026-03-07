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

    // TODO. 测试时将BeanLifecycle对象Mock掉, 启动时会使用Mock对象
    //  但是Mock对象的属性还未赋值导致调用失败, Spring容器无法正常启动
    @Bean
    public CommandLineRunner eventDescriptorRunner(BeanLifecycle beanLifecycle) {
        return args -> {
            BeanProperty bp = beanLifecycle.getBeanProperty();
            System.out.println(bp.getNumber());
        };
    }
}