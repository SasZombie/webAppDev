package org.example.lab2.services;
import org.example.lab2.domain.Product;


import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product p);

    List<Product> filter(Product.cathegory cat, Long p);
}
