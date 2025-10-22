package spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.config.IncludeContextConfig;
import spring.config.MyProfileConfig;
import spring.service.HomeService;

// TODO. Spring IT 测试类不能位于空包路径下
// @SpringBootTest自动找到主启动类@SpringBootApplication
// @SpringBootTest会启动整个Spring Boot容器, 根据Package包路径查找
@SpringBootTest(
        classes = SpringBootTestingApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, // 配置随机端口
        properties = {"custom.property.name=test-value"})           // 为测试设置特殊属性值
@TestPropertySource(locations = "classpath:application-it.properties") // 使用特定properties属性
@ContextConfiguration(classes = {IncludeContextConfig.class}) // 指定Spring Context容器配置
@ExtendWith(SpringExtension.class) // 添加Extension扩展，控制测试前后执行逻辑
@ActiveProfiles("test") // 激活测试的Profile，避免注入特定的Bean
public class SpringBootITTest {

    // TODO. 不能在测试类型中直接添加@Bean方法
    // Test Class cannot include @Bean methods
    // public MyClass myClass() {
    //     return new MyClass();
    // }

    @Test
    public void testSpringBootApplicationMain() {
        // MyProfileConfig.ProfileClass profileClass = ApplicationContextProvider.getBean(MyProfileConfig.ProfileClass.class);
        // profileClass.print();

        IncludeContextConfig.IncludedBean includedBean = ApplicationContextProvider.getBean(IncludeContextConfig.IncludedBean.class);
        includedBean.print();

        HomeService homeService = ApplicationContextProvider.getBean(HomeService.class);
        homeService.printHome();
    }
}
