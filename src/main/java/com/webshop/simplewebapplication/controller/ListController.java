package com.webshop.simplewebapplication.controller;

import com.webshop.simplewebapplication.Service.ProductService2;
import com.webshop.simplewebapplication.model.Product2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ListController {

    @GetMapping("/")
    public String index(Model model) {
        ProductService2 productService2 = new ProductService2();
        List<Product2> products = productService2.findAll();
        model.addAttribute("items", products);
        System.out.println("list");
        return "index";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        ProductService2 productService2 = new ProductService2();
        List<Product2> products = productService2.findAllInCart();
        model.addAttribute("items", products);
        System.out.println("list in cart ");
        return "cart";
    }


}
