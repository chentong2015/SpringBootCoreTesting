package spring.injection;

import org.springframework.stereotype.Component;

@Component
public class BeanLifecycle {

    private final BeanProperty beanProperty;

    public BeanLifecycle(BeanProperty beanProperty) {
        this.beanProperty = beanProperty;
    }

    public BeanProperty getBeanProperty() {
        return beanProperty;
    }
}
