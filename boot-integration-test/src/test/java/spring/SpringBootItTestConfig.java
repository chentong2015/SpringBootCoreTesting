package spring;

import org.springframework.boot.test.context.TestConfiguration;

// @TestConfiguration 不会被@ComponentScan自动扫描
// 专门用于测试环境的配置类, 用于给测试添加或覆盖Bean
@TestConfiguration
public class SpringBootItTestConfig {

}

// 案例: 使用@TestConfiguration在特定的IT测试作用域内
// @SpringBootTest
// class UserServiceTest {
//
//    @TestConfiguration
//    static class Config {
//
//        @Bean
//        UserRepository userRepository() {
//            return new FakeUserRepository();
//        }
//    }
// }
