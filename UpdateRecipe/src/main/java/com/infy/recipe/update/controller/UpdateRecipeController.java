package com.infy.recipe.update.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.recipe.update.dto.RecipeDTO;
import com.infy.recipe.update.exception.RecipeException;
import com.infy.recipe.update.service.UpdateRecipe;


@RestController
@Validated
@RequestMapping(value="/recipe")
public class UpdateRecipeController {

	@Autowired
	UpdateRecipe updateRecipe;
	
	
	@PutMapping(value="/update/people/{recipeId}")
	public ResponseEntity<String> updatePeople(@PathVariable Integer recipeId, @RequestBody @Valid RecipeDTO recipe) throws RecipeException{
		String successMessage = updateRecipe.updatePeople(recipeId,recipe.getNoOfPeople());
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	@PutMapping(value="/update/name/{recipeId}")
	public ResponseEntity<String> updateName(@PathVariable Integer recipeId, @RequestBody @Valid RecipeDTO recipe) throws RecipeException{
		String successMessage = updateRecipe.updateName(recipeId, recipe.getRecipeName());
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	@PutMapping(value="/update/time/{recipeId}")
	public ResponseEntity<String> updateTime(@PathVariable Integer recipeId, @RequestBody @Valid RecipeDTO recipe) throws RecipeException{
		String successMessage = updateRecipe.updateTime(recipeId,recipe.getTime());
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	@PutMapping(value="/update/vegeterian/{recipeId}")
	public ResponseEntity<String> updateVeg(@PathVariable Integer recipeId,@RequestBody @Valid RecipeDTO recipe) throws RecipeException{
		String successMessage =updateRecipe.updateVeg(recipeId,recipe.getIsVegeterian());
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	@PutMapping(value="/update/ingredients/{recipeId}")
	public ResponseEntity<String> updateIngredients(@PathVariable Integer recipeId,@RequestBody @Valid RecipeDTO recipe) throws RecipeException{
		String successMessage = updateRecipe.updateIngredients(recipeId,recipe.getIngredients());
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	@PutMapping(value="/update/instructions/{recipeId}")
	public ResponseEntity<String> updateInstructions(@PathVariable Integer recipeId,@RequestBody @Valid RecipeDTO recipe) throws RecipeException{
		String successMessage = updateRecipe.updateInstructions(recipeId,recipe.getInstructions());
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
}
