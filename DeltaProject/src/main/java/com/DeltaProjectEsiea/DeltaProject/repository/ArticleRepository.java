package com.DeltaProjectEsiea.DeltaProject.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DeltaProjectEsiea.DeltaProject.model.Article;

@Repository
public interface ArticleRepository 
	extends CrudRepository<Article, Integer> {

	// Derived Query
	public Iterable<Article> findByName(String name);
	
	// Native Query
	@Query(value = "SELECT * FROM articles WHERE name = :name", nativeQuery = true)
	public Iterable<Article> findByNameNative(@Param("name") String name);
	
	@Query(value = "SELECT * FROM articles WHERE category_category_id = :categoryId", nativeQuery = true)
	public Iterable<Article> findByCategoryId(@Param("categoryId") Integer categoryId);
	
}
