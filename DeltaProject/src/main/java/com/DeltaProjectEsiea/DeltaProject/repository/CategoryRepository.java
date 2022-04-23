package com.DeltaProjectEsiea.DeltaProject.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DeltaProjectEsiea.DeltaProject.model.Category;

@Repository
public interface CategoryRepository 
	extends CrudRepository<Category, Integer> {

		// Derived Query
		public Iterable<Category> findByName(String name);
		
		// Native Query
		@Query(value = "SELECT * FROM categories WHERE name = :name", nativeQuery = true)
		public Iterable<Category> findByNameNative(@Param("name") String name);
}
