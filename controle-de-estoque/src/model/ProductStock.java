/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author lucas-souza
 */
public class ProductStock {
    
    private static ProductStock stock = null;
    private ArrayList<Product> products;
    
    private ProductStock(){
        this.products =  new ArrayList<>();
    }
    
    public static ProductStock getStock(){
        if(stock == null){
            stock = new ProductStock();
            return stock;
        } else {
            return stock;
        }
    }
    
    public ArrayList<Product> getProducts(){
        return this.products;
    }
    
    public boolean addProduct(Product product){
        boolean productExists;        
        productExists = checkProductExistence(product);
        if(!productExists){
            return products.add(product);
        } else {
            return false;
        }
    }
    
    public boolean removeProduct(Product product){
        return products.removeIf(prod -> (product.getRegistration() == prod.getRegistration()));
    }

    private boolean checkProductExistence(Product product){
        boolean productExists = false;
        for( Product prod : products){
            if(prod.getRegistration() == product.getRegistration()){
                productExists  = true;
            }
        }
        return productExists;
    }
}
