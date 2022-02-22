package com.emusic.dao;

import com.emusic.model.Product;

import java.util.List;

public interface ProductsDAO {

    void addProduct(Product product);

    Product getProductById(int id);

    List<Product> getAllProducts();

    void deleteProduct(int id);
}
