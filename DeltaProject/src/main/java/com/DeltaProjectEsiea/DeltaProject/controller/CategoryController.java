package com.DeltaProjectEsiea.DeltaProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DeltaProjectEsiea.DeltaProject.model.Category;
import com.DeltaProjectEsiea.DeltaProject.model.Article;
import com.DeltaProjectEsiea.DeltaProject.service.CategoryService;
import com.DeltaProjectEsiea.DeltaProject.service.NotAllowedException;
import com.DeltaProjectEsiea.DeltaProject.service.NotFoundException;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryFull> getCategory(@PathVariable("id") Integer id) {
		try {
			CategoryFull p = categoryService.getCategory(id);
			return new ResponseEntity<CategoryFull>(p, HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<CategoryFull>(HttpStatus.NOT_FOUND);
		}
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
	
	@PutMapping("")
	public ResponseEntity<CategoryFull> replaceCategory(@RequestBody Category category) {
		try {
			CategoryFull articleF =  categoryService.update(category);
			return new ResponseEntity<CategoryFull>(articleF, HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<CategoryFull>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<CategoryFull> addCategory(@RequestBody Category category) {
		try {
			CategoryFull categoryF = categoryService.create(category);
			return new ResponseEntity<>(categoryF, HttpStatus.OK);
		} catch (NotAllowedException e) {
			//System.out.println("machinefngwg");
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") Integer id) {
		try {
			categoryService.deleteCategory(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
