package com.application.dispatch.api.rest.customer;

import com.application.dispatch.entity.Product;
import com.application.dispatch.service.ProductService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer/product")
public class ProductCustomerController {

	private ProductService productService;
	
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping(value = "/list")
    public List<Product> list(Model model){
        List<Product> productList = productService.getAllProducts();
        return productList;
    }
    @GetMapping(value = "/show/{id}")
    public Product showProduct(@PathVariable Integer id, Model model){
       Product product = productService.getProductById(id);
        return product;
    }
    
}
