package com.infy.recipe.update.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.recipe.update.entity.Recipe;
import com.infy.recipe.update.exception.RecipeException;
import com.infy.recipe.update.repository.RecipeRepository;


@Service
public class UpdateRecipeImpl implements UpdateRecipe{
	@Autowired
	RecipeRepository recipeRepo;

	@Override
	public String updatePeople(Integer recipeId, Integer noOfPeople) throws RecipeException{
		// TODO Auto-generated method stub
		Optional<Recipe> optional=recipeRepo.findById(recipeId);
		Recipe recipe=optional.orElseThrow(()->new RecipeException("Service.RECIPE_NOT_FOUND"));
		recipe.setNoOfPeople(noOfPeople);
		recipeRepo.save(recipe);
		return "No. of people updated to "+recipe.getNoOfPeople()+" for Recipe Id : "+recipe.getRecipeId();
	}

	@Override
	public String updateTime(Integer recipeId, LocalDateTime time) throws RecipeException {
		// TODO Auto-generated method stub
		Optional<Recipe> optional=recipeRepo.findById(recipeId);
		Recipe recipe=optional.orElseThrow(()->new RecipeException("Service.RECIPE_NOT_FOUND"));
		recipe.setTime(time);
		recipeRepo.save(recipe);
		return "Time updated to " +recipe.getTime()+" for Recipe Id : "+recipe.getRecipeId();
	}

	@Override
	public String updateVeg(Integer recipeId, boolean isVegeterian) throws RecipeException {
		// TODO Auto-generated method stub
		Optional<Recipe> optional=recipeRepo.findById(recipeId);
		Recipe recipe=optional.orElseThrow(()->new RecipeException("Service.RECIPE_NOT_FOUND"));
		recipe.setIsVegeterian(isVegeterian);
		recipeRepo.save(recipe);
		return "Veg indicator updated to "+recipe.getIsVegeterian()+" for Recipe Id : "+recipe.getRecipeId();
	}

	@Override
	public String updateIngredients(Integer recipeId, String ingredients) throws RecipeException {
		// TODO Auto-generated method stub
		Optional<Recipe> optional=recipeRepo.findById(recipeId);
		Recipe recipe=optional.orElseThrow(()->new RecipeException("Service.RECIPE_NOT_FOUND"));
		recipe.setIngredients(ingredients);
		recipeRepo.save(recipe);
		return "Ingredients updated to "+recipe.getIngredients()+" for Recipe Id : "+recipe.getRecipeId();
	}

	@Override
	public String updateInstructions(Integer recipeId, String instructions) throws RecipeException {
		// TODO Auto-generated method stub
		Optional<Recipe> optional=recipeRepo.findById(recipeId);
		Recipe recipe=optional.orElseThrow(()->new RecipeException("Service.RECIPE_NOT_FOUND"));
		recipe.setInstructions(instructions);
		recipeRepo.save(recipe);
		return "Instructions updated to "+recipe.getInstructions()+" for Recipe Id : "+recipe.getRecipeId();
	}

	@Override
	public String updateName(Integer recipeId, String recipeName) throws RecipeException {
		// TODO Auto-generated method stub
		Optional<Recipe> optional=recipeRepo.findById(recipeId);
		Recipe recipe=optional.orElseThrow(()->new RecipeException("Service.RECIPE_NOT_FOUND"));
		recipe.setRecipeName(recipeName);
		recipeRepo.save(recipe);
		return "Recipe name updated to "+recipe.getRecipeName()+" for Recipe Id : "+recipe.getRecipeId();
	}

}
