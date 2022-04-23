package com.DeltaProjectEsiea.DeltaProject.transformer.article;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
		articleFull.setAuthor(article.getAuthor());
		articleFull.setContent(article.getContent());
		articleFull.setDate(article.getDate());
		CategoryLight categoryLight = new CategoryLight();
		categoryLight.setName(article.getCategory().getName());
		articleFull.setCategory(categoryLight);
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
		p.setAuthor(article.getAuthor());
		p.setContent(article.getContent());
		p.setDate(article.getDate());
		p.setCategory(categoryTransformer.untransform(article.getCategory()));
		return p;
	}

}
