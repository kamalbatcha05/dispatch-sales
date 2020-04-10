package com.application.dispatch.service.impl;

import com.application.dispatch.entity.Category;
import com.application.dispatch.repository.CategoryRepository;
import com.application.dispatch.service.CategoryService;
import com.application.dispatch.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
//	@Override
//	public Page<Category> getPaginatedCategories(Pageable pageable) {
//        return categoryRepository.findAll(pageable);
//    }

	@Override
	public void saveCategory(Category category) {
		category.setStatus(null != category.getStatus() ?
				category.getStatus() : Constants.ACTIVE);
		categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		Category existingCategory = getCategoryById(category.getId());
		
		existingCategory.setCategoryName(category.getCategoryName());
		existingCategory.setDescription(category.getDescription());
		existingCategory.setStatus(category.getStatus());
		categoryRepository.save(existingCategory);
		return existingCategory;
	}
	
	@Override
	public Category getCategoryById(int id) {
        return categoryRepository.findCategoryById(id);
	}

	@Override
	public void deleteCategory(int id) {
//		categoryRepository.delete(id);;
	}
}
