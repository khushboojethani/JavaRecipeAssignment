package com.infy.recipe.delete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.recipe.delete.exception.RecipeException;
import com.infy.recipe.delete.service.DeleteRecipe;

@RestController
@RequestMapping(value="/recipe")
public class DeleteRecipeController {
	
	@Autowired
	DeleteRecipe deleteRecipe;
	
	@Autowired 
	Environment environment;
	
	@DeleteMapping(value="/delete/{recipeId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer recipeId) throws RecipeException{
		String successMessage = deleteRecipe.deleteRecipe(recipeId);
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
}
