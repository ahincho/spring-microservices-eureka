package com.cjava.client.application.services;

import com.cjava.client.domain.entities.Client;
import com.cjava.client.domain.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServicePostgres implements ClientService {

    ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return this.clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return this.clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client createClient(Client client) {
        return this.clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, Client client) {
        Optional<Client> existingClient = this.clientRepository.findById(id);
        if (existingClient.isEmpty()) {
            return null;
        }
        Client getSale = existingClient.get();
        getSale.setName(client.getName());
        return this.clientRepository.save(getSale);
    }

    @Override
    public Client deleteClient(Long id) {
        Optional<Client> existingClient = this.clientRepository.findById(id);
        if (existingClient.isEmpty()) {
            return null;
        }
        this.clientRepository.deleteById(id);
        return existingClient.get();
    }

}
