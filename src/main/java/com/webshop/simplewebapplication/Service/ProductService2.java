package com.webshop.simplewebapplication.Service;

import com.webshop.simplewebapplication.model.Product2;

import java.util.ArrayList;
import java.util.List;

public class ProductService2 {
    //      static Map<Integer, Product2> products = new HashMap<>();
    static List<Product2> allProduct = new ArrayList<>();
    static List<Product2> productInCart = new ArrayList<>();

    public void addProduct(int id, String name, int price) {
        Product2 product = new Product2(id, name, price, "  You can add it in cart, if button is active");
        allProduct.add(product);
    }

    public void addProductInCart(int id) {
        Product2 product = findById(id);
        product.setStatus("   Already in the cart, if you add again, the product will be in the cart again ");
        productInCart.add(product);
    }

    public Product2 findById(int id){
        Product2 product = new Product2();
        for (Product2 p:allProduct) {
            if (id == p.getId()){
                product = p;
            }
        }
        return product;
    }

    public void delete(int id){
        int currentId = 0;
        for (int i =0; i+1 < allProduct.size(); i++) {
            if (id == allProduct.get(i).getId()){
                currentId =i;
            }
        }
        allProduct.remove(currentId);
        productInCart.remove(currentId);
    }
    public void deleteFromCart(int id){
        int currentId = 0;
        for (int i =0; i+1 < productInCart.size(); i++) {
            if (id == productInCart.get(i).getId()){
                currentId =i;
            }
        }
        allProduct.get(currentId).setStatus("You can add it ina cart, if button is active");
        productInCart.remove(currentId);
    }

    public List<Product2> findAll(){
        return  allProduct;
    }
    public List<Product2> findAllInCart(){
        return  productInCart;
    }

    public  int countOfProduct (){
        return allProduct.size();
    }
}
