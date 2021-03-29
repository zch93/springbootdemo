package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class ProductServiceClassTEST {

    @Autowired
    ProductRepository productRepository;


    //getting all product records
    public List<Product> getAllStudent()
    {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(product -> products.add(product));
        return products;
    }

    //getting a specific record
    public Product getProductById(int id)
    {
        return productRepository.findById(id).get();
    }

    @Transactional
    public void saveOrUpdate(Product product)
    {
        productRepository.save(product);
    }

    @Transactional
    //deleting a specific record
    public void delete(int id)
    {
        productRepository.deleteById(id);
    }

}
