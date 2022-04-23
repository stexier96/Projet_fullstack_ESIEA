package com.DeltaProjectEsiea.DeltaProject.transformer.category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.DeltaProjectEsiea.DeltaProject.model.Category;
import com.DeltaProjectEsiea.DeltaProject.model.Article;
import com.DeltaProjectEsiea.DeltaProject.transformer.article.ArticleLight;

@Component
public class CategoryTransformer {

	public CategoryFull transform(Category category) {
		CategoryFull categoryFull = new CategoryFull();
		categoryFull.setCategoryId(category.getCategoryId());
		categoryFull.setName(category.getName());
		
		for(Article article : category.getArticles()) {
			ArticleLight articleLight = new ArticleLight();
			articleLight.setId(article.getId());
			articleLight.setName(article.getName());
			articleLight.setContent(article.getContent());
			articleLight.setAuthor(article.getAuthor());
			articleLight.setDate(article.getDate());
			
			categoryFull.getArticles().add(articleLight);
		}		
		return categoryFull;
	}
	
	public List<CategoryFull> transform(Iterable<Category> categories) {
		List<CategoryFull> categoriesFull = new ArrayList<>();
		for(Category category : categories) {
			categoriesFull.add(transform(category));
		}
		return categoriesFull;
	}
/*
	public List<Category> untransform(List<CategoryLight> categoriesLight) {
		List<Category> categories = new ArrayList<>();
		for(CategoryLight categoryL : categoriesLight) {
			categories.add(untransform(categoryL));
		}
		return categories;
	}*/
	
	public Category untransform(CategoryLight categoryL) {
		Category category = new Category();
		category.setCategoryId(categoryL.getCategoryId());
		category.setName(categoryL.getName());
		return category;
	}	
	
}