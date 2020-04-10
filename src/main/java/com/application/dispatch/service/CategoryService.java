package com.application.dispatch.service;

import com.application.dispatch.entity.Category;

import java.util.List;

public interface CategoryService {
	
	List<Category> getAllCategories();

//	Page<Category> getPaginatedCategories(Pageable pageable);
	
    void saveCategory(Category category);
    
    Category updateCategory(Category category);
    
    Category getCategoryById(int id);
    
    void deleteCategory(int id);
}
