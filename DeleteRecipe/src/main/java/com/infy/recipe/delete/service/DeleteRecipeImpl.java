package com.infy.recipe.delete.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.recipe.delete.entity.Recipe;
import com.infy.recipe.delete.exception.RecipeException;
import com.infy.recipe.delete.repository.RecipeRepository;

@Service
public class DeleteRecipeImpl implements DeleteRecipe{

	@Autowired
	RecipeRepository recipeRepo;
	
	@Override
	public String deleteRecipe(Integer recipeId) throws RecipeException{
		// TODO Auto-generated method stub
		Optional<Recipe> optional=recipeRepo.findById(recipeId);
		optional.orElseThrow(() -> new RecipeException("Service.RECIPE_NOT_FOUND"));
		recipeRepo.deleteById(recipeId);
		return "Recipe deleted for recipe Id:"+recipeId;
	}

}
