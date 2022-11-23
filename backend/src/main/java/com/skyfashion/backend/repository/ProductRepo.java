package com.skyfashion.backend.repository;


import com.skyfashion.backend.entity.Product;

import java.util.List;

public interface ProductRepo  {
    public List<Product> findAll();
    public Product findByName(String name);
    public void add(Product product);
    public void update(Product product);
    public void delete(Product product);
}
