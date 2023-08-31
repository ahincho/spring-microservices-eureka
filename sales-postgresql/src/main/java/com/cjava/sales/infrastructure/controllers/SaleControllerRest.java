package com.cjava.sales.infrastructure.controllers;

import com.cjava.sales.application.services.SaleService;
import com.cjava.sales.domain.entities.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sales")
public class SaleControllerRest implements SaleController {

    @Autowired
    SaleService saleService;

    @Value("${server.port}")
    private Integer port;

    @Override
    @GetMapping
    public List<Sale> findAll() {
        return this.saleService.findAll().stream().peek(sale -> sale.setPort(port)).collect(Collectors.toList());
    }

    @Override
    @GetMapping("/{id}")
    public Sale findById(@PathVariable("id") Long id) {
        Sale sale = this.saleService.findById(id);
        sale.setPort(port);
        return sale;
    }

    @Override
    @GetMapping("/user/{id}")
    public List<Sale> findByUserId(@PathVariable("id") Long userId) {
        return this.saleService.findByUserId(userId).stream().peek(sale -> sale.setPort(port)).collect(Collectors.toList());
    }

    @Override
    @PostMapping
    public Sale create(@RequestBody Sale purchase) {
        return this.saleService.createSale(purchase);
    }

    @Override
    @PutMapping("/{id}")
    public Sale update(@PathVariable("id") Long id, @RequestBody Sale purchase) {
        return this.saleService.updateSale(id, purchase);
    }

    @Override
    @DeleteMapping("/{id}")
    public Sale delete(@PathVariable("id") Long id) {
        return this.saleService.deleteSale(id);
    }

    @Override
    @GetMapping("/amount/{id}")
    public Double sumAmountByUserId(@PathVariable("id") Long userId) {
        return this.saleService.sumAmountByUserId(userId);
    }

}
