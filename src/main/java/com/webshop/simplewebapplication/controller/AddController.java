package com.webshop.simplewebapplication.controller;

import com.webshop.simplewebapplication.Service.ProductService2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

public class AddController {

    @PostMapping("/add/confirm")
    public String add(@RequestParam("name") String name,
                    @RequestParam("price") int price)  {

        ProductService2 productService2 = new ProductService2();
        productService2.addProduct(productService2.countOfProduct() + 1, name, price);

        System.out.println("add product in list");
        return "confirm";
    }

    @GetMapping("/add")
    public String add1()  {

        return "addProduct";
    }

    @ResponseBody
    @RequestMapping(path = "/add/{id}/cart", method = RequestMethod.POST)
    public void addInCart(@PathVariable("id") int id) {
        ProductService2 prSer = new ProductService2();
        prSer.addProductInCart(id);
        System.out.println("add in cart" + id);
//        return "redirect/:";
    }
}
