package com.DeltaProjectEsiea.DeltaProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.DeltaProjectEsiea.DeltaProject.model.Category;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
