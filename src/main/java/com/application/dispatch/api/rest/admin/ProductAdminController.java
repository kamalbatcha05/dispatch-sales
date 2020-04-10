package com.application.dispatch.api.rest.admin;

import com.application.dispatch.entity.Product;
import com.application.dispatch.service.ProductService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/product")
public class ProductAdminController {

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
    @PostMapping(value = "/add")
    public ResponseEntity saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product){
        Product storedProduct = productService.getProductById(id);
        storedProduct.setProductName(product.getProductName());
        storedProduct.setDescription(product.getDescription());
        storedProduct.setStatus(product.getStatus());
        productService.saveProduct(storedProduct);
        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
    }
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
//        productService.deleteProduct(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }
    
}
