package com.emusic.controller;

import com.emusic.dao.ProductDao;
import com.emusic.dao.ProductsDAO;
import com.emusic.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class HomeController {

    private Path path;

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
    public String viewProduct(@PathVariable int productId, Model model) throws IOException {
        //We create a new object instance of product from the productDao and we use a new function getProductId()
        Product product = productsDAO.getProductById(productId);
        model.addAttribute(product);

        return "viewProduct";
    }

    @RequestMapping("/admin")
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model){
        List<Product> products = productsDAO.getAllProducts();
        model.addAttribute("products",products);

        return "productInventory";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        product.setProductCategory("Instrument");
        product.setProductCondition("new");
        product.setProductStatus("active");

        model.addAttribute("product",product);

        return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct",method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product")Product product, HttpServletRequest request){
        productsDAO.addProduct(product);

        MultipartFile productImage = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        if (productImage !=null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed",e);
            }
        }

        return "redirect:/admin/productInventory";

    }

    @RequestMapping("/admin/productInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id,Model model){

        productsDAO.deleteProduct(id);

        return "redirect:/admin/productInventory";
    }
}
