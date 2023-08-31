package com.cjava.client.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

import com.cjava.client.application.services.SaleService;
import com.cjava.client.domain.dtos.ClientResponse;
import com.cjava.client.domain.entities.Client;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientControllerRest implements ClientController {

    CircuitBreakerFactory circuitBreakerFactory;

    @Qualifier("saleServiceFeign")
    SaleService saleService;

    RestTemplate restTemplate;

    @Override
    @GetMapping("/amount/{id}")
    public Double getUserSaleAmount(@PathVariable("id") Long userId) {
        return circuitBreakerFactory.create("sales")
                .run(() -> saleService.getUserSaleAmount(userId), e -> getUserSaleAmountBackup(e, userId));
    }

    public Double getUserSaleAmountBackup(Throwable e, Long userId) {
        String backupUrl = "http://cjava-sales/api/sales/amount/" + userId;
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
