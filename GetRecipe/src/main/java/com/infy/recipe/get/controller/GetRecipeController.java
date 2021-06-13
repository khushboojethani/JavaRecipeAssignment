package com.infy.recipe.get.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.recipe.get.dto.RecipeDTO;
import com.infy.recipe.get.exception.RecipeException;
import com.infy.recipe.get.service.GetRecipe;

@RestController
@RequestMapping(value="/recipe")
public class GetRecipeController {

	@Autowired
	GetRecipe getRecipe;
	
	@Autowired
	Environment environment;
	
	@GetMapping(value = "/get")
	public ResponseEntity<List<RecipeDTO>> getAllRecipes() throws RecipeException{
		List<RecipeDTO> recipeList = getRecipe.getAll();
		return new ResponseEntity<>(recipeList, HttpStatus.OK);
	}
}
