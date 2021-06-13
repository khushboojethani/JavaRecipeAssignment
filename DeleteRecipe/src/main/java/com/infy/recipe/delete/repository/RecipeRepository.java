package com.infy.recipe.delete.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.recipe.delete.entity.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe,Integer>{

}
