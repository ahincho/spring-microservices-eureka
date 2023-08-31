package com.cjava.sales.infrastructure.controllers;

import org.springframework.web.bind.annotation.*;

import jakarta.ws.rs.core.MediaType;

import lombok.AllArgsConstructor;

import java.util.List;

import com.cjava.sales.application.services.SaleService;
import com.cjava.sales.domain.entities.Sale;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sales")
public class SaleControllerRest implements SaleController {

    SaleService saleService;

    @Override
    @GetMapping
    public List<Sale> findAll() {
        return this.saleService.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Sale findById(@PathVariable("id") Long id) {
        return this.saleService.findById(id);
    }

    @Override
    @GetMapping("/user/{id}")
    public List<Sale> findByUserId(@PathVariable("id") Long userId) {
        return this.saleService.findByUserId(userId);
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

    @GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_JSON)
    public String getHealthCheck() {
        return "{ \"todoOk\" : true }";
    }

}
