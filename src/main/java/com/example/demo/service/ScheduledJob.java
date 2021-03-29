package com.example.demo.service;

import com.example.demo.model.RandomProductGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledJob {

    private final RandomProductGenerator randomProduct = new RandomProductGenerator();

    @Autowired
    ProductServiceClassTEST productServiceClassTEST;

    @Scheduled(fixedRate = 10000, initialDelay = 5000)
    public void generatePOST() {
        productServiceClassTEST.saveOrUpdate(randomProduct.generateRandomProduct());
    }

    @Scheduled(fixedRate = 20000, initialDelay = 10000)
    public void generateDELETE() {
        productServiceClassTEST.delete(randomProduct.getRemovableID());
    }

}
