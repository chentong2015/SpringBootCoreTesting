package spring.component;

import org.springframework.boot.test.context.TestComponent;

// 专门为测试定义的Component对象, 排除在应用层面的Component扫描
// bean is intended only for tests, and should be excluded from Spring Boot's component scanning.
@TestComponent
public class BeanTestComponent {

}
