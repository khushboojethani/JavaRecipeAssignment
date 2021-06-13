package com.infy.recipe.update.service;

import java.time.LocalDateTime;

import com.infy.recipe.update.exception.RecipeException;

public interface UpdateRecipe {
	public String updatePeople(Integer recipeId,Integer noOfPeople) throws RecipeException;
	public String updateName(Integer recipeId,String recipeName) throws RecipeException;
	public String updateTime(Integer recipeId,LocalDateTime time) throws RecipeException;
	public String updateVeg(Integer recipeId,boolean isVegeterian) throws RecipeException;
	public String updateIngredients(Integer recipeId,String ingredients) throws RecipeException;
	public String updateInstructions(Integer recipeId,String instructions) throws RecipeException;
}
