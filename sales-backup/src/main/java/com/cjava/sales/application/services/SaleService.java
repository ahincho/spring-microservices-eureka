package com.cjava.sales.application.services;

import java.util.List;

import com.cjava.sales.domain.entities.Sale;

public interface SaleService {

    List<Sale> findAll();
    Sale findById(Long id);
    List<Sale> findByUserId(Long userId);
    Sale createSale(Sale sale);
    Sale updateSale(Long id, Sale sale);
    Sale deleteSale(Long id);
    Double sumAmountByUserId(Long userId);

}
