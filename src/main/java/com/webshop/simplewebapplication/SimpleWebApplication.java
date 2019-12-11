package com.webshop.simplewebapplication;

import com.webshop.simplewebapplication.Service.ProductService2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableAutoConfiguration
public class SimpleWebApplication {

	public static void main(String[] args) {
//		String st = "asd123121";
//		System.out.println("+++++++++++++");
//		System.out.println(ProductService.findAll());
//		Product product = new Product(ProductService.countOfProduct() + 1L, st, 121233, "");
//		System.out.println(product.getName());
//		ProductService.addProduct(ProductService.countOfProduct() + 1L, st, 121233, "");
		ProductService2 ps =new ProductService2();
		ps.addProduct(3,"something3",432321);
		ps.addProduct(1,"something1",1123);
		ps.addProduct(2,"something2",13223);

		SpringApplication.run(SimpleWebApplication.class, args);
		System.out.println("http://127.0.0.1:8080/");
	}

}
