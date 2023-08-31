package com.cjava.client.application.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import com.cjava.client.application.feign.SaleFeignClient;

@Primary
@Service("saleServiceFeign")
@AllArgsConstructor
public class SaleServiceFeign implements SaleService {

    SaleFeignClient saleFeignClient;

    @Override
    public Double getUserSaleAmount(Long userId) {
        return this.saleFeignClient.getUserSaleAmount(userId);
    }

}
