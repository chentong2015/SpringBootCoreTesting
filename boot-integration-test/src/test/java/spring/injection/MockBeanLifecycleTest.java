package spring.injection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
public class MockBeanLifecycleTest {

    // TODO. 创建Mock对象替代注入的Bean对象, Mock对象的BeanProperty属性初始为null
    //  1. @InjectMocks自动注入属性Bean
    //  2. Mock Getter方法返回自定义Bean
    @MockitoBean
    private BeanLifecycle beanLifecycle;

    // TODO. BeforeAll启动在SpringContext容器启动之前, 但无法修改Mock对象
    @BeforeAll
    static void beforeAll() {
        System.out.println("Run beforeAll");
    }

    // TODO. BeforeEach方法的执行是在SpringContext容器启动完成后
    //  如果Spring容器启动时需要调用Mock对象, 可能属性Null导致启动失败 !!
    @BeforeEach
    public void beforeEach() {
        // 仅对单元测试生效
        System.out.println("Run beforeEach");
        Mockito.when(this.beanLifecycle.getBeanProperty()).thenReturn(new BeanProperty());
    }

    @Test
    public void testPrint() {
        Assertions.assertNotNull(this.beanLifecycle);
        Assertions.assertNotNull(this.beanLifecycle.getBeanProperty());
    }
}
