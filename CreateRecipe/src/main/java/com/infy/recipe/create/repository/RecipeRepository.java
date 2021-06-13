package com.infy.recipe.create.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.recipe.create.entity.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Integer>{
	
}
