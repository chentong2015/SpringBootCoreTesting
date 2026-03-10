package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ClientServiceItTestSolution2 {

    // TODO. 使用MockBean避免共享注入的Bean对象，每个单元测试独立Mock
    @MockitoBean
    ClientService service;

    @Test
    void shouldAddPetWhenNotAlreadyExisting() {
        Client client = new Client("ABBC");
        Mockito.when(service.add(client)).thenReturn(true);
        boolean result = service.add(client);
        assertThat(result).isTrue();

        Set<Client> clientSet = new HashSet<>();
        clientSet.add(client);
        Mockito.when(service.getClients()).thenReturn(clientSet);
        assertThat(service.getClients()).hasSize(1);
    }

    @Test
    void shouldAddPetWhenNotAlreadyExisting2() {
        Client client = new Client("ABBC");
        Mockito.when(service.add(client)).thenReturn(true);
        boolean result = service.add(client);
        assertThat(result).isTrue();

        Mockito.when(service.getClients()).thenReturn(new HashSet<>());
        assertThat(service.getClients()).hasSize(0);
    }
}