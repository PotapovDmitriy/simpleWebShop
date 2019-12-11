package com.webshop.simplewebapplication.controller;

import com.webshop.simplewebapplication.Service.ProductService2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeleteController {
    @ResponseBody
    @RequestMapping(path = "/item/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable("id") int id) {
        ProductService2 prSer = new ProductService2();
        prSer.delete(id);
       return "index";
    }

    @ResponseBody
    @RequestMapping(path = "/item/{id}/delete/cart", method = RequestMethod.POST)
    public String deleteFromCart(@PathVariable("id") int id) {
        ProductService2 prSer = new ProductService2();
        prSer.deleteFromCart(id);
        System.out.println("delete from cart");
        return "cart";
    }

}
