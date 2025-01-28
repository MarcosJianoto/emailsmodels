package com.emailsmodels.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emailsmodels.dto.CategoryDTO;
import com.emailsmodels.entities.Category;
import com.emailsmodels.services.CategoryService;

@RestController
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@PostMapping("/savecategory")
	public ResponseEntity<Void> saveCategory(@RequestBody CategoryDTO categoryDTO) {

		categoryService.saveCategory(categoryDTO);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/updatecategory/{id}")
	public ResponseEntity<Void> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable Integer id) {

		categoryService.updateCategory(categoryDTO, id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/getcategorybyid/{id}")
	public ResponseEntity<Category> getCategoryForId(@PathVariable Integer id) {
		Category category = categoryService.getCategoryForId(id);
		return ResponseEntity.ok().body(category);
	}

	@GetMapping("/getcategory")
	public ResponseEntity<List<CategoryDTO>> getCategoryForId() {
		List<CategoryDTO> categoryDTOs = categoryService.getCategory();
		return ResponseEntity.ok().body(categoryDTOs);
	}

	@DeleteMapping("/deletecategory/{id}")
	public void deleteCategory(@PathVariable Integer id) {
		categoryService.deleteCategory(id);
	}
}
