package com.cjava.sales.domain.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cjava.sales.domain.entities.Sale;

import java.util.List;

@Repository
public interface SaleRepository extends MongoRepository<Sale, Long> {

    List<Sale> findByUserId(Long userId);

}
