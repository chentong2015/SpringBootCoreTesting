package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClientServiceItTestSolution1 {

    @Autowired
    ClientService service;

    // TODO. 在单元测试结束后清除Context缓存数据
    @Test
    @DirtiesContext
    void shouldAddPetWhenNotAlreadyExisting() {
        Client client = new Client("ABBC");
        boolean result = service.add(client);

        assertThat(result).isTrue();
        assertThat(service.getClients()).hasSize(1);
    }

    @Test
    @DirtiesContext
    void shouldNotAddPetWhenAlreadyExisting() {
        Client client = new Client("123");
        boolean result = service.add(client);
        assertThat(result).isTrue();

        result = service.add(client);
        assertThat(result).isFalse();
        assertThat(service.getClients()).hasSize(1);
    }
}
