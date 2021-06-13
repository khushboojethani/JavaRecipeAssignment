package com.infy.recipe.create.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infy.recipe.create.dto.RecipeDTO;
import com.infy.recipe.create.exception.RecipeException;
import com.infy.recipe.create.service.CreateRecipe;

@RestController
@Validated
@RequestMapping(value="/recipe")
public class CreateRecipeController {
	
	@Autowired
	CreateRecipe createRecipe;
	
	@Autowired 
	private Environment environment;
	
	//add a recipe
	@PostMapping(value="/add")
	public ResponseEntity<String> addRecipe(@RequestBody @Valid RecipeDTO recipe) throws RecipeException{
		String recipeName=createRecipe.addRecipe(recipe);
		String successMessage=environment.getProperty("API.ADD_SUCCESS")+recipeName;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
		
	}
	
}
