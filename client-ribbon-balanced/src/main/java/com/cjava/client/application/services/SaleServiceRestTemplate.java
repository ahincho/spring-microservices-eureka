package com.cjava.client.application.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Service("saleRestTemplate")
@AllArgsConstructor
public class SaleServiceRestTemplate implements SaleService {

    RestTemplate restTemplate;

    @Override
    public Double getUserSaleAmount(Long userId) {
        return this.restTemplate.getForObject("http://cjava-sales/api/sales/amount/" + userId, Double.class);
    }

}
