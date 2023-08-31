package com.cjava.client.application.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cjava-sales")
public interface SaleFeignClient {

    @GetMapping("api/sales/amount/{id}")
    Double getUserSaleAmount(@PathVariable("id") Long userId);

}
