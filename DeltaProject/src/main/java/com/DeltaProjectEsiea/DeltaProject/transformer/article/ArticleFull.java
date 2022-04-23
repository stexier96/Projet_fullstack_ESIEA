package com.DeltaProjectEsiea.DeltaProject.transformer.article;

import java.util.ArrayList;
import java.util.List;

import com.DeltaProjectEsiea.DeltaProject.transformer.category.CategoryLight;

public class ArticleFull extends ArticleLight {
	
	private List<CategoryLight> categories = new ArrayList<>();
	
	public List<CategoryLight> getCategories() {
		return categories;
	}
	public void setCategories(List<CategoryLight> categories) {
		this.categories = categories;
	}
	
	
}
