package com.ecommerce.ecommproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EcommProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommProductServiceApplication.class, args);
    }

}
