package com.cjava.client.application.services;

import com.cjava.client.application.feign.SaleFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service("saleServiceFeign")
@AllArgsConstructor
public class SaleServiceFeign implements SaleService {

    SaleFeignClient saleFeignClient;

    @Override
    public Double getUserSaleAmount(Long userId) {
        return this.saleFeignClient.getUserSaleAmount(userId);
    }

}
