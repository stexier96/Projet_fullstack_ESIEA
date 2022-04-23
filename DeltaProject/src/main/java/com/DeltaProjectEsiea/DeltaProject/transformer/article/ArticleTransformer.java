package com.DeltaProjectEsiea.DeltaProject.transformer.article;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DeltaProjectEsiea.DeltaProject.model.Category;
import com.DeltaProjectEsiea.DeltaProject.model.Article;
import com.DeltaProjectEsiea.DeltaProject.transformer.category.CategoryLight;
import com.DeltaProjectEsiea.DeltaProject.transformer.category.CategoryTransformer;

@Component
public class ArticleTransformer {
	
	@Autowired
	private CategoryTransformer categoryTransformer;

	public ArticleFull transform(Article article) {
		ArticleFull articleFull = new ArticleFull();
		articleFull.setId(article.getId());
		articleFull.setName(article.getName());
		articleFull.setDescription(article.getDescription());
		articleFull.setCost(article.getCost());

		for (Category category : article.getCategories()) {
			CategoryLight categoryLight = new CategoryLight();
			categoryLight.setCategoryId(category.getCategoryId());
			categoryLight.setName(category.getName());
			articleFull.getCategories().add(categoryLight);
		}

		return articleFull;
	}

	public List<ArticleFull> transform(Iterable<Article> articles) {
		List<ArticleFull> articlesFull = new ArrayList<>();
		for (Article article : articles) {
			articlesFull.add(transform(article));
		}
		return articlesFull;
	}
	
	public Article untransform(ArticleFull article) {
		Article p = new Article();
		p.setId(article.getId());
		p.setName(article.getName());
		p.setDescription(article.getDescription());
		p.setCost(article.getCost());
		p.setCategories(categoryTransformer.untransform(article.getCategories()));
		return p;
	}

}
