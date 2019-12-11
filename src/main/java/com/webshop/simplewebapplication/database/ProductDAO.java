package com.webshop.simplewebapplication.database;

import com.webshop.simplewebapplication.model.Product;

import java.util.List;


public interface ProductDAO {
    void addProduct(Product product);
    List<Product> findAll();
    Product findProduct(long id );
    void deleteProduct(Product product);
    int countOfProduct();
}
