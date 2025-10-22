package spring.injection;

import org.springframework.stereotype.Component;

@Component
public class BeanProperty {

    private int number = 10;

    public int getNumber() {
        return number;
    }
}
