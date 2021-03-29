package com.example.demo.model;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class RandomProductGenerator {

    private static final Random rand = new Random();

    private final Set<String> identifiers = new HashSet<String>();
    private final Deque<Integer> idRepo = new LinkedList<>();

    public Product generateRandomProduct() {
        int productID = rand.nextInt(100);
        String productName = randomProductName();

        idRepo.add(productID);

        return new Product(productID, productName);
    }

    private static final String LEXICON = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

    private String randomProductName() {

        String productName = null;

        while (true) {
            int length = rand.nextInt(5) + 5;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                builder.append(LEXICON.charAt(rand.nextInt(LEXICON.length())));
            }
            if (!identifiers.contains(builder.toString())) {
                productName = builder.toString();
                break;
            }
        }
        return productName;
    }

    public int getRemovableID() {
        int removableID = idRepo.removeFirst();

        return removableID;
    }


}
