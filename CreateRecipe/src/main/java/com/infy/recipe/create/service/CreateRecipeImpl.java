package com.infy.recipe.create.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infy.recipe.create.dto.RecipeDTO;
import com.infy.recipe.create.entity.Recipe;
import com.infy.recipe.create.exception.RecipeException;
import com.infy.recipe.create.repository.RecipeRepository;

@Service
public class CreateRecipeImpl implements CreateRecipe {

	@Autowired
	RecipeRepository recipeRepo;
	
	@Autowired
	Environment environment;
	
	@Override
	public String addRecipe(RecipeDTO recipeDto) throws RecipeException {
		// TODO Auto-generated method stub
		List<Recipe> recipes=(List<Recipe>) recipeRepo.findAll();
		for(Recipe recipe:recipes) {
			if(recipe.getRecipeName().equalsIgnoreCase(recipeDto.getRecipeName())) {
				throw new RecipeException("Service.RECIPE_FOUND");
			}
		}
		Recipe r=new Recipe();
		if(recipeDto.getRecipeName()==null ||recipeDto.getRecipeName().isEmpty()) {
			throw new RecipeException("Service.INVALID_DETAILS");
		}
		r.setRecipeName(recipeDto.getRecipeName());
		if(recipeDto.getIngredients()==null ||recipeDto.getIngredients().isEmpty()) {
			throw new RecipeException("Service.INVALID_DETAILS");
		}
		r.setIngredients(recipeDto.getIngredients());
		if(recipeDto.getNoOfPeople()==null) {
			throw new RecipeException("Service.INVALID_DETAILS");
		}
		r.setNoOfPeople(recipeDto.getNoOfPeople());
		if(recipeDto.getInstructions()==null ||recipeDto.getInstructions().isEmpty()) {
			throw new RecipeException("Service.INVALID_DETAILS");
		}
		r.setInstructions(recipeDto.getInstructions());
		if(recipeDto.getIsVegeterian()==null) {
			throw new RecipeException("Service.INVALID_DETAILS");
		}
		r.setIsVegeterian(recipeDto.getIsVegeterian());
		recipeRepo.save(r);
		return r.getRecipeName();
	}

}
