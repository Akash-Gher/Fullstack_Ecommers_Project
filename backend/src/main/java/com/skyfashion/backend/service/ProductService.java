package com.skyfashion.backend.service;


import com.skyfashion.backend.entity.Product;
import com.skyfashion.backend.repository.ProductRepo;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductService implements ProductRepo {
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Product> findAll() {
        Session currSession = entityManager.unwrap(Session.class);
        return currSession.createQuery("from Product p order by p.price desc").getResultList();
    }

    @Override
    @Transactional
    public Product findByName(String name) {
        Session currSession = entityManager.unwrap(Session.class);
        Query query = currSession.createQuery("from Product p where p.name=:name");
        query.setParameter("name", name);
        List<Product> list = query.getResultList();
        return (!list.isEmpty()) ? list.get(0) : null;
    }

    @Override
    @Transactional
    public void add(Product product) {
        Session currSession = entityManager.unwrap(Session.class);
        currSession.save(product);
    }

    @Override
    @Transactional
    public void update(Product product) {
        Session currSession = entityManager.unwrap(Session.class);
        Product checkIfExists = this.findByName(product.getName());
        product.setId(checkIfExists.getId());
        currSession.clear();
        currSession.update(product);
    }
    @Override
    @Transactional
    public void delete(Product product) {
        Session currSession = entityManager.unwrap(Session.class);
        currSession.delete(product);
    }
}
