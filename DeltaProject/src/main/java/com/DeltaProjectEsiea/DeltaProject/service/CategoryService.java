package com.DeltaProjectEsiea.DeltaProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.DeltaProjectEsiea.DeltaProject.model.Category;
import com.DeltaProjectEsiea.DeltaProject.repository.CategoryRepository;
import com.DeltaProjectEsiea.DeltaProject.transformer.category.CategoryFull;
import com.DeltaProjectEsiea.DeltaProject.transformer.category.CategoryTransformer;

@Service
public class CategoryService {

	@Autowired
	private CategoryTransformer categoryTransformer;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public CategoryFull create(Category category) throws NotAllowedException {
		return upsert(category);
		/*if (category.getCategoryId() == null) {
			System.out.println("print create cool");
			return upsert(category);
		} else {
			System.out.println("print create pas cool");
			throw new NotAllowedException();
		}*/
	}
	
	public List<CategoryFull> getCategories() {
		return categoryTransformer.transform(categoryRepository.findAll());
	}

	public Optional<Category> getEntityCategory(Integer idCategory) {
		return categoryRepository.findById(idCategory);
	}
	
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	public CategoryFull update(Category category) throws NotFoundException {
		getCategory(category.getCategoryId());
		return upsert(category);
	}

	private CategoryFull upsert(Category category) {
		return categoryTransformer.transform(categoryRepository.save(category));

	}
	
	public CategoryFull getCategory(Integer categoryId) throws NotFoundException {
		Optional<Category> res = categoryRepository.findById(categoryId);
		if (res.isPresent()) {
			return categoryTransformer.transform(res.get());
		} else {
			throw new NotFoundException();
		}
	}
	
	public void deleteCategory(Integer id) throws NotFoundException {
		try {
			categoryRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException();
		}
	}
}
