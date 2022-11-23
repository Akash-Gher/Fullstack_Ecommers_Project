package com.skyfashion.backend.controller;


import com.skyfashion.backend.entity.Product;
import com.skyfashion.backend.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/")
    // Enable CORES on port 3000
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Product>> showAll() {
        return new ResponseEntity<>(productRepo.findAll(), HttpStatus.OK);
       // return new ResponseEntity<> (productRepo.findAll(), HttpStatus.OK);   // previous line
    }

    @GetMapping("/{name}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Product> showByName(@PathVariable String name) {
        Product product = productRepo.findByName(name);
        //User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //System.out.println(user == null);
        //if (user == null) System.out.println("Item is being requested anonymously");
        //else System.out.println("Item is being requested by" + user.getUsername() + " with id " + user.getId());
        if (product == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> add(@RequestBody Product product) {
        System.out.println("Controller " + product);
        productRepo.add(new Product(product.getName(), product.getTitle(), product.getDescription(), product.getPrice(), product.getType(), product.getDetails()));
        return new ResponseEntity<>("Successfully added " + product.getName(), HttpStatus.OK);
    }

    @PostMapping("/update")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> update(@RequestBody Product product) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("Item is being edited by" + userDetails.getUsername());
        productRepo.update(new Product(product.getName(), product.getTitle(), product.getDescription(), product.getPrice(), product.getType(), product.getDetails()));
        return new ResponseEntity<>("Successfully added " + product.getName(), HttpStatus.OK);
    }




    @DeleteMapping("/delete/{name}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> delete(@PathVariable String name) {
        Product product = productRepo.findByName(name);
        if (product == null) return new ResponseEntity<>("No user found to delete",
                HttpStatus.NOT_FOUND);
        productRepo.delete(product);
        return new ResponseEntity<>("Sucessfully deleted " + name, HttpStatus.OK);
    }

}
