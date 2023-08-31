package com.cjava.sales.infrastructure.controllers;

import com.cjava.sales.domain.entities.Sale;

import java.util.List;

public interface SaleController {

    List<Sale> findAll();
    Sale findById(Long id);
    List<Sale> findByUserId(Long userId);
    Sale create(Sale purchase);
    Sale update(Long id, Sale purchase);
    Sale delete(Long id);
    Double sumAmountByUserId(Long userId);

}
