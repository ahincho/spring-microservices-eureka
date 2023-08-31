package com.cjava.sales.application.services;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

import com.cjava.sales.domain.entities.Sale;
import com.cjava.sales.domain.repositories.SaleRepository;

@Service
@AllArgsConstructor
public class SaleServiceMongoDb implements SaleService {

    SaleRepository saleRepository;

    @Override
    public List<Sale> findAll() {
        return this.saleRepository.findAll();
    }

    @Override
    public Sale findById(Long id) {
        return this.saleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Sale> findByUserId(Long userId) {
        return this.saleRepository.findByUserId(userId);
    }

    @Override
    public Sale createSale(Sale sale) {
        return this.saleRepository.save(sale);
    }

    @Override
    public List<Sale> createSales(List<Sale> sales) {
        return this.saleRepository.saveAll(sales);
    }

    @Override
    public Sale updateSale(Long id, Sale sale) {
        Optional<Sale> existingSale = this.saleRepository.findById(id);
        if (existingSale.isEmpty()) {
            return null;
        }
        Sale getSale = existingSale.get();
        getSale.setUserId(sale.getUserId());
        getSale.setDate(sale.getDate());
        getSale.setAmount(sale.getAmount());
        return this.saleRepository.save(getSale);
    }

    @Override
    public Sale deleteSale(Long id) {
        Optional<Sale> existingSale = this.saleRepository.findById(id);
        if (existingSale.isEmpty()) {
            return null;
        }
        this.saleRepository.deleteById(id);
        return existingSale.get();
    }

    @Override
    public Double sumAmountByUserId(Long userId) {
        List<Sale> sales = this.saleRepository.findByUserId(userId);
        if (sales.isEmpty()) {
            return 0.0;
        }
        return sales.stream().mapToDouble(Sale::getAmount).sum();
    }

}
