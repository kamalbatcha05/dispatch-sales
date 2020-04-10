package com.application.dispatch.service;

import com.application.dispatch.entity.Category;
import com.application.dispatch.entity.Product;

import java.util.List;

public interface ProductService {

	List<Product> getAllProducts();

//	Page<Product> getPaginatedProducts(Pageable pageable);
	
    void saveProduct(Product product);
    
    Product updateProduct(Product product);
    
    Product getProductById(int id);
    
//    void deleteProduct(int id);
    
    Category getCategoryById(int id);
	 
}
