package com.example.fileup_ex.repository;

import com.example.fileup_ex.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    private final Map<Long, Product> products = new HashMap<>();
    private long sequence = 0L;

    public void save(Product product) {
        product.setId(++sequence);
        products.put(product.getId(), product);
    }

    public Product findById(Long id) {
        return products.get(id);
    }

}
