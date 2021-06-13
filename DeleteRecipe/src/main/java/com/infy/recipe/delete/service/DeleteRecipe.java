package com.infy.recipe.delete.service;

import com.infy.recipe.delete.exception.RecipeException;

public interface DeleteRecipe {
	public String deleteRecipe(Integer recipeId) throws RecipeException;
}
