package com.application.dispatch.repository;

import com.application.dispatch.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findCategoryById(int id);
	
}