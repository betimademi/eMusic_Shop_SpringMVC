// This ProductDAOExample class is used in the beginning of a project while we didnt have configured database so we use dummy data to import
// Now after we configured database we are using Interface ProductDAO
package com.emusic.dao;

import com.emusic.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {


    public List<Product> getProductList(){

        Product product1 = new Product();

        product1.setProductId(100);
        product1.setProductName("Guitar");
        product1.setProductCategory("Instrument");
        product1.setProductDescription("Wood made for HardRock");
        product1.setProductPrice(400);
        product1.setProductCondition("New");
        product1.setProductManufacturer("HarmanCardon");
        product1.setProductStatus("Active");
        product1.setUnitInStock(5);

        Product product2 = new Product();

        product2.setProductId(2000);
        product2.setProductName("Trumbs");
        product2.setProductCategory("Instrument");
        product2.setProductDescription("Steel made for LimpBizkit");
        product2.setProductPrice(899);
        product2.setProductCondition("New");
        product2.setProductManufacturer("Bosse");
        product2.setProductStatus("Active");
        product2.setUnitInStock(10);

        Product product3 = new Product();

        product3.setProductId(300);
        product3.setProductName("Speaker");
        product3.setProductCategory("Instrument");
        product3.setProductDescription("Iron made for Pop");
        product3.setProductPrice(355);
        product3.setProductCondition("New");
        product3.setProductManufacturer("Polk");
        product3.setProductStatus("Active");
        product3.setUnitInStock(10);

        List<Product> productList = new ArrayList<Product>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        return productList;
    }

    public Product getProductById(int productId) throws IOException{
        for(Product product:getProductList()){
            if(product.getProductId()==(productId)){
                return product;
            }
        }
        throw new IOException(("No product found!"));
    }


}
