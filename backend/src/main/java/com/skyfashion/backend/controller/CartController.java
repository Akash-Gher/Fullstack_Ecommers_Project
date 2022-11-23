package com.skyfashion.backend.controller;



import com.skyfashion.backend.entity.Cart;
import com.skyfashion.backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/auth/")
public class CartController {

    @Autowired
    private CartService cartservice;
    @GetMapping("/cart")
    public List<Cart> list(){
        return cartservice.getProductsList();
    }
    @PostMapping("/add_product")
    public Cart addProduct(@RequestBody Cart entry){
        return cartservice.addToCart(entry);
    }


}
