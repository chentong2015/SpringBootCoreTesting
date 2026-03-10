package org.example;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class ClientService {

    private Set<Client> clients;

    public ClientService() {
        this.clients = new HashSet<>();
    }

    public Set<Client> getClients() {
        return Collections.unmodifiableSet(clients);
    }

    public boolean add(Client client) {
        return this.clients.add(client);
    }
}
