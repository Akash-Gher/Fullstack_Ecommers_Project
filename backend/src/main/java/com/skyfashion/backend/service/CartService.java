package com.skyfashion.backend.service;


import com.skyfashion.backend.entity.Cart;
import com.skyfashion.backend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    public List<Cart> getProductsList(){
        return cartRepository.findAll();
    }

    public Cart addToCart(Cart entry){
        return cartRepository.save(entry);
    }
}


