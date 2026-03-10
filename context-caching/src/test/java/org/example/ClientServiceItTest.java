package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClientServiceItTest {

    @Autowired
    ClientService service;

    @Test
    void shouldAddPetWhenNotAlreadyExisting() {
        Client client = new Client("ABBC");
        boolean result = service.add(client);

        assertThat(result).isTrue();
        assertThat(service.getClients()).hasSize(1);
    }

    // TODO. 两个单元测试共享一个Application Context(同一个bean对象)
    // 当共同运行时会由于缓存的Bean对象造成测试的失败
    @Test
    void shouldNotAddPetWhenAlreadyExisting() {
        Client client = new Client("123");
        boolean result = service.add(client);
        assertThat(result).isTrue();

        result = service.add(client);
        assertThat(result).isFalse();
        assertThat(service.getClients()).hasSize(1);
    }
}
