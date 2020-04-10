package com.application.dispatch.api.rest.customer;

import com.application.dispatch.entity.Category;
import com.application.dispatch.service.CategoryService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer/category")
public class CategoryCustomerController {

	private CategoryService categoryService;
	
    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping(value = "/list")
    public List<Category> list(Model model){
        List<Category> categories = categoryService.getAllCategories();
        return categories;
    }
    @GetMapping(value = "/show/{id}")
    public Category showCategory(@PathVariable Integer id, Model model){
       Category category = categoryService.getCategoryById(id);
       return category;
    }
}
