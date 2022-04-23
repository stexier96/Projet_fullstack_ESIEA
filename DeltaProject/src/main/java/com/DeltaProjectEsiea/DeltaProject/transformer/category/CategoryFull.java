package com.DeltaProjectEsiea.DeltaProject.transformer.category;

import java.util.ArrayList;
import java.util.List;

import com.DeltaProjectEsiea.DeltaProject.transformer.article.ArticleLight;

public class CategoryFull extends CategoryLight {
	
	private List<ArticleLight> articles = new ArrayList<>();
	
	public List<ArticleLight> getArticles() {
		return articles;
	}
	public void setArticles(List<ArticleLight> articles) {
		this.articles = articles;
	}
}
