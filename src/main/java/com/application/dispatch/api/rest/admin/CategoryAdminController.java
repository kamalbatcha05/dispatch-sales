package com.application.dispatch.api.rest.admin;

import com.application.dispatch.entity.Category;
import com.application.dispatch.service.CategoryService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/category")
public class CategoryAdminController {

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
    @PostMapping(value = "/add")
    public ResponseEntity saveCategory(@RequestBody Category category){
        categoryService.saveCategory(category);
        return new ResponseEntity("Category saved successfully", HttpStatus.OK);
    }
    @PutMapping(value = "/update/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id, @RequestBody Category category){
        Category updatedCategory = categoryService.getCategoryById(id);
        updatedCategory.setCategoryName(category.getCategoryName());
        updatedCategory.setDescription(category.getDescription());
        updatedCategory.setStatus(category.getStatus());
        categoryService.saveCategory(updatedCategory);
        return new ResponseEntity("Category updated successfully", HttpStatus.OK);
    }
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        categoryService.deleteCategory(id);
        return new ResponseEntity("Category deleted successfully", HttpStatus.OK);
    }
    
}
