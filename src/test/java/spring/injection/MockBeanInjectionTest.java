package spring.injection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
public class MockBeanInjectionTest {

    // TODO. Mock掉Spring Context中注入的Bean对象
    @MockitoBean
    private BeanInjection beanInjection;

    @Test
    public void testMockBeanInjection() {
        Mockito.when(beanInjection.getId()).thenReturn(100);

        System.out.println(beanInjection.getId());
        Assertions.assertTrue(true);
    }
}
