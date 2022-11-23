package com.skyfashion.backend.repository;


import com.skyfashion.backend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CartRepository extends JpaRepository<Cart,String> {
}
