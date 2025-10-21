package spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import spring.config.ExcludedContextConfig;
import spring.config.IncludeContextConfig;
import spring.service.HomeService;

// TODO. Spring IT 测试类不能位于空包路径下
// @SpringBootTest自动找到主启动类@SpringBootApplication
// @SpringBootApplication必须位于测试类的包路径中
// 1. 配置要启动的SpringBoot启动类，否则根据Package包路径查找
// 2. 配置应用启动的随机端口，避免多个测试post冲突
// 3. 设置测试时使用的properties属性
@SpringBootTest(classes = SpringBootTestingApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = {"custom.security.name=testname"})
// 在测试是设置特定properties属性
@TestPropertySource(locations = "classpath:application-it.properties")
// 激活针对于测试的Profile
@ActiveProfiles("test")

// 在测试时加载指定的Spring容器配置
// @ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@ContextConfiguration(classes = {IncludeContextConfig.class})
// 配置测试时要移除的Spring容器配置
@EnableAutoConfiguration(exclude = ExcludedContextConfig.class)

// 为测试添加Extension扩展，控制测试前后执行逻辑
@ExtendWith(SpringExtension.class)
public class SpringBootITTest {

    // TODO. 不能在测试类型中直接添加@Bean方法
    // Test Class cannot include @Bean methods
    // public MyClass myClass() {
    //     return new MyClass();
    // }

    // 测试Main的启动并从SpringContext中获取注入的bean
    @Test
    public void testSpringBootApplicationMain() {
        IncludeContextConfig.IncludedBean includedBean =
                ApplicationContextProvider.getBean(IncludeContextConfig.IncludedBean.class);
        includedBean.print();

        HomeService homeService = ApplicationContextProvider.getBean(HomeService.class);
        homeService.printHome();
    }
}
