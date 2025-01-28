package com.emailsmodels.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.emailsmodels.dto.CategoryDTO;
import com.emailsmodels.entities.Category;
import com.emailsmodels.repositories.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public void validateCategoryDTO(CategoryDTO categoryDTO) {
		if (categoryDTO == null || categoryDTO.getName() == null || categoryDTO.getName().isBlank()) {
			throw new IllegalArgumentException("Invalid category data");
		}
	}

	public void saveCategory(CategoryDTO categoryDTO) {

		validateCategoryDTO(categoryDTO);

		Category category = new Category();
		category.setName(category.getName());

		categoryRepository.save(category);
	}

	public void updateCategory(CategoryDTO categoryDTO, Integer id) throws IllegalArgumentException {

		validateCategoryDTO(categoryDTO);

		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("CategoryDTO not found"));

		category.setName(category.getName());
		categoryRepository.save(category);

	}

	public Category getCategoryForId(Integer id) throws IllegalArgumentException {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("CategoryDTO not found"));
		Category dto = new Category();
		dto.setName(category.getName());

		return dto;
	}

	public List<CategoryDTO> getCategory() throws IllegalArgumentException {
		List<Category> findAllCategory = categoryRepository.findAll();
		List<CategoryDTO> getCategoryList = new ArrayList<>();

		if (!findAllCategory.isEmpty()) {

			for (Category cat : findAllCategory) {
				CategoryDTO category = new CategoryDTO();
				category.setId(cat.getId());
				category.setName(cat.getName());
				getCategoryList.add(category);
			}
		}

		return getCategoryList;
	}

	public void deleteCategory(Integer id) {
		categoryRepository.deleteById(id);
	}

}
