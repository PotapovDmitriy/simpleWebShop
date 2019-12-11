package com.webshop.simplewebapplication.Service;

import com.webshop.simplewebapplication.database.ProductDAO;
import com.webshop.simplewebapplication.database.ProductDAOHib;
import com.webshop.simplewebapplication.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService  {
//    @Autowired
    private static ProductDAO dataBase = new ProductDAOHib();

    public static void addProduct(Long id, String name, int price) {
        Product product = new Product(id, name, price);
        dataBase.addProduct(product);
    }


    public static List<Product> findAll() {
        return dataBase.findAll();
    }


    public static Product findProduct(long id) {
        return dataBase.findProduct(id);
    }

    public static int countOfProduct (){
        return dataBase.countOfProduct();
    }


    public static void deleteProduct(Product product) {
        dataBase.deleteProduct(product);
    }
}
