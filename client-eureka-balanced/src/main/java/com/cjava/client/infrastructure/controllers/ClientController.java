package com.cjava.client.infrastructure.controllers;

import com.cjava.client.domain.dtos.ClientResponse;
import com.cjava.client.domain.entities.Client;

import java.util.List;

public interface ClientController {

    List<ClientResponse> findAll();
    ClientResponse findById(Long id);
    ClientResponse createClient(Client client);
    Double getUserSaleAmount(Long userId);
    Double getUserSaleAmountBackup(Throwable e, Long userId);

}
