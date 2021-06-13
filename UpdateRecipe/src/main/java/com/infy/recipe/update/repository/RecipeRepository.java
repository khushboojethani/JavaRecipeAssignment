package com.infy.recipe.update.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.recipe.update.entity.Recipe;


public interface RecipeRepository extends CrudRepository<Recipe,Integer>{

}
