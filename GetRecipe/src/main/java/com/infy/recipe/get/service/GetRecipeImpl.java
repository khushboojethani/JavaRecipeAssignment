package com.infy.recipe.get.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.recipe.get.dto.RecipeDTO;
import com.infy.recipe.get.entity.Recipe;
import com.infy.recipe.get.exception.RecipeException;
import com.infy.recipe.get.repository.RecipeRepository;

@Service
public class GetRecipeImpl implements GetRecipe{

	@Autowired
	RecipeRepository recipeRepo;
	
	@Override
	public List<RecipeDTO> getAll() throws RecipeException{
		// TODO Auto-generated method stub
		List<Recipe> recipes=(List<Recipe>) recipeRepo.findAll();
		if(recipes.isEmpty()) {
			throw new RecipeException("Service.NO_RECIPES_FOUND");
		}
		List<RecipeDTO> recipeList=new ArrayList<>();
		recipes.forEach(recipe->{
			RecipeDTO rdto=new RecipeDTO();
			rdto.setRecipeId(recipe.getRecipeId());
			rdto.setRecipeName(recipe.getRecipeName());
			rdto.setIsVegeterian(recipe.getIsVegeterian());
			rdto.setNoOfPeople(recipe.getNoOfPeople());
			String[] in=recipe.getIngredients().split(",");
			rdto.setIngredients(in);
			rdto.setInstructions(recipe.getInstructions());
			recipeList.add(rdto);
		});
		return recipeList;
	}
}
