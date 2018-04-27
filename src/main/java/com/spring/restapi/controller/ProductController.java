package com.spring.restapi.controller;

import com.spring.restapi.model.Product;
import com.spring.restapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public Iterable<Product> products(){
        return productRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "products")
    public String save(@RequestBody Product product){
        productRepository.save(product);

        return product.getId();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    public Product show(@PathVariable String id){
        return productRepository.findById(id).orElseGet(null);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product){
        Product prod = productRepository.findById(id).get();
        if(product.getProdName() != null){
            prod.setProdName(product.getProdName());
       }
       if(product.getProdDescr() != null){
           prod.setProdDescr(product.getProdDescr());
       }

        productRepository.save(prod);

        return prod;
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
    public String delete(@PathVariable String id){
        Product product = productRepository.findById(id).orElseGet(null);
        productRepository.delete(product);

        return "product deleted";
    }

}
