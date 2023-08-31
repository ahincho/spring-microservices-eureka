package com.cjava.client.application.services;

import com.cjava.client.domain.entities.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();
    Client findById(Long id);
    Client createClient(Client client);
    Client updateClient(Long id, Client client);
    Client deleteClient(Long id);

}
