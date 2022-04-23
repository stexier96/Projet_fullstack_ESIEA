package com.DeltaProjectEsiea.DeltaProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DeltaProjectEsiea.DeltaProject.model.Category;
import com.DeltaProjectEsiea.DeltaProject.model.Article;
import com.DeltaProjectEsiea.DeltaProject.service.CategoryService;
import com.DeltaProjectEsiea.DeltaProject.service.ArticleService;
import com.DeltaProjectEsiea.DeltaProject.transformer.category.CategoryFull;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/private/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("")
	public List<CategoryFull> getCategories() {
		return categoryService.getCategories();
	}
	
	@PostMapping("/{idCategory}/{idArticle}")
	public void addArticleToCategory(
			@PathVariable(name = "idCategory") Integer idCategory,
			@PathVariable(name = "idArticle") Integer idArticle) {
		
		Category category = categoryService.getEntityCategory(idCategory).get();
		Article article = articleService.getEntityArticle(idArticle).get();
		
		category.addArticle(article);
		
		categoryService.saveCategory(category);
	
	}
	
}
