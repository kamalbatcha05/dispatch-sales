package com.application.dispatch.service.impl;

import com.application.dispatch.entity.Category;
import com.application.dispatch.entity.Product;
import com.application.dispatch.repository.CategoryRepository;
import com.application.dispatch.repository.ProductRepository;
import com.application.dispatch.service.ProductService;
import com.application.dispatch.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
//	@Override
//	public Page<Product> getPaginatedProducts(Pageable pageable) {
//        return productRepository.findAll(pageable);
//    }

	@Override
	public void saveProduct(Product product) {
		product.setStatus(null != product.getStatus() ? product.getStatus() : Constants.ACTIVE);
		productRepository.save(product);
	}
	
	@Override
	public Product updateProduct(Product product) {
		Product existingProduct = getProductById(product.getId());
		
		existingProduct.setProductName(product.getProductName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setStatus(product.getStatus());
		existingProduct.setCategory(product.getCategory());
		productRepository.save(existingProduct);
		return existingProduct;
	}
	
	@Override
	public Category getCategoryById(int id) {
        return categoryRepository.getOne(id);
	}

	@Override
	public Product getProductById(int id) {
		return productRepository.findProductById(id);
	}

	/*@Override
	public void deleteProduct(int id) {
		productRepository.delete(id);;
	}*/
	
}