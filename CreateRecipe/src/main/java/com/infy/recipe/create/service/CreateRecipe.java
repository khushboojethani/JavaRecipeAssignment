package com.infy.recipe.create.service;

import com.infy.recipe.create.dto.RecipeDTO;
import com.infy.recipe.create.exception.RecipeException;

public interface CreateRecipe {
	public String addRecipe(RecipeDTO recipe) throws RecipeException;
}
