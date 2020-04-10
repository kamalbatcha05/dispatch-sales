package com.application.dispatch.repository;

import com.application.dispatch.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {
//    Product findProductByName(String name);

	Product findProductById(int id);

//	Page<Product> findAll(Pageable pageable);
}