package com.emusic.controller;

import com.emusic.dao.ProductDao;
import com.emusic.dao.ProductsDAO;
import com.emusic.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

//    private final ProductDao productDao = new ProductDao(); we used in dummy data
    @Autowired
    private ProductsDAO productsDAO;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

//    @RequestMapping("/productListExample")
//    public String getProductsExample(Model model){
//        List<Product> productList = productsDAO.getAllProducts();
//        Product product = productList.get(0);
//        model.addAttribute(product);
//
//        return "productListExample";
//    }
    @RequestMapping("/productListOriginal")
    public String getProducts(Model model){
        List<Product> products = productsDAO.getAllProducts();
        model.addAttribute("products",products);

        return "productListOriginal";
    }

    @RequestMapping("/productListOriginal/viewProduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws IOException {
        //We create a new object instance of product from the productDao and we use a new function getProductId()
        Product product = productsDAO.getProductById(productId);
        model.addAttribute(product);

        return "viewProduct";
    }

    @RequestMapping("/admin")
    public String adminPage(){
        return "admin";
    }

}
