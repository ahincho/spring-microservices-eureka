package com.cjava.client.infrastructure.controllers;

import java.util.List;

import com.cjava.client.domain.dtos.ClientResponse;
import com.cjava.client.domain.entities.Client;

public interface ClientController {

    Double getUserSaleAmount(Long userId);
    Double getUserSaleAmountBackup(Throwable e, Long userId);

}
