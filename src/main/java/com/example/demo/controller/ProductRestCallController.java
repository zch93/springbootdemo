package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductServiceClassTEST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestCallController {

    @Autowired
    ProductServiceClassTEST productServiceClassTEST;

    //creating a get mapping that retrieves all the products detail from the database
    @GetMapping("/product")
    private List<Product> getAllStudent()
    {
        return productServiceClassTEST.getAllStudent();
    }

    @GetMapping("/product/{id}")
    private Product getProduct(@PathVariable("id") int id)
    {
        return productServiceClassTEST.getProductById(id);
    }

    @DeleteMapping("/product/{id}")
    private void deleteProduct(@PathVariable("id") int id)
    {
        productServiceClassTEST.delete(id);
    }

    @PostMapping("/product")
    private int saveProduct(@RequestBody Product product)
    {
       productServiceClassTEST.saveOrUpdate(product);
       return product.getId();
    }
}
