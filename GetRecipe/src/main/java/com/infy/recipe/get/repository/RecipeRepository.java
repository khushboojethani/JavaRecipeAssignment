package com.infy.recipe.get.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.recipe.get.entity.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Integer>{

}
