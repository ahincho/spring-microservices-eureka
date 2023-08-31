package com.cjava.client.infrastructure.controllers;

import com.cjava.client.application.services.ClientService;
import com.cjava.client.application.services.SaleService;
import com.cjava.client.domain.dtos.ClientResponse;
import com.cjava.client.domain.entities.Client;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientControllerRest implements ClientController {

    CircuitBreakerFactory circuitBreakerFactory;

    @Qualifier("saleService")
    SaleService saleService;

    ClientService clientService;

    RestTemplate restTemplate;

    @Override
    @GetMapping
    public List<ClientResponse> findAll() {
        return this.clientService.findAll().stream().map(this::mapClientToClientResponse).toList();
    }

    @Override
    @GetMapping("/{id}")
    public ClientResponse findById(@PathVariable("id") Long id) {
        return mapClientToClientResponse(this.clientService.findById(id));
    }

    @Override
    @PostMapping
    public ClientResponse createClient(@RequestBody Client client) {
        return mapClientToClientResponse(this.clientService.createClient(client));
    }

    @Override
    @GetMapping("/amount/{id}")
    public Double getUserSaleAmount(@PathVariable("id") Long userId) {
        return circuitBreakerFactory.create("sales")
                .run(() -> saleService.getUserSaleAmount(userId), e -> getUserSaleAmountBackup(e, userId));
    }

    public Double getUserSaleAmountBackup(Throwable e, Long userId) {
        String backupUrl = "http://cjava-sales-backup/api/sales/amount/" + userId;
        return restTemplate.getForObject(backupUrl, Double.class);
    }

    private ClientResponse mapClientToClientResponse(Client client) {
        return ClientResponse.builder()
                .id(client.getId())
                .name(client.getName())
                .salesAmount(this.getUserSaleAmount(client.getId()))
                .build();
    }

}
