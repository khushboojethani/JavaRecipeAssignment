package com.infy.recipe.get.service;

import java.util.List;

import com.infy.recipe.get.dto.RecipeDTO;
import com.infy.recipe.get.exception.RecipeException;

public interface GetRecipe {
	public List<RecipeDTO> getAll() throws RecipeException;
}
