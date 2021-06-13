package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import com.infy.recipe.create.dto.RecipeDTO;
import com.infy.recipe.create.entity.Recipe;
import com.infy.recipe.create.exception.RecipeException;
import com.infy.recipe.create.repository.RecipeRepository;
import com.infy.recipe.create.service.CreateRecipe;
import com.infy.recipe.create.service.CreateRecipeImpl;

@SpringBootTest(classes = { CreateRecipeApplicationTests.class })
public class CreateRecipeApplicationTests {
	
	@Autowired
	Environment environment;
	
	@Mock
	RecipeRepository recipeRepo;
	 
	@InjectMocks
	CreateRecipe recipeService=new CreateRecipeImpl();
	
	@Test
	public void addRecipeValid() throws RecipeException{
		RecipeDTO recipe=new RecipeDTO();
		recipe.setRecipeName("pizza");
		recipe.setIngredients("crust,cheese,toppings,veggies");
		recipe.setInstructions("1.Make your own pizza dough.2.Keep the sauce and toppings simple.3. Bake it hot.");
		recipe.setIsVegeterian(false);
		recipe.setNoOfPeople(8);
		List<Recipe> recipes=new ArrayList<>();
		Mockito.when(recipeRepo.findAll()).thenReturn(recipes);
		Assertions.assertEquals("pizza",recipeService.addRecipe(recipe));
	}

	@Test
	public void recipeAlreadyPresent() throws RecipeException{
		RecipeDTO recipe=new RecipeDTO();
		recipe.setRecipeName("pizza");
		Recipe r=new Recipe();
		r.setRecipeName("pizza");
		List<Recipe> recipes=new ArrayList<>();
		recipes.add(r);
		Mockito.when(recipeRepo.findAll()).thenReturn(recipes);
		RecipeException e=Assertions.assertThrows(RecipeException.class,()->recipeService.addRecipe(recipe));
		Assertions.assertEquals("Service.RECIPE_FOUND", e.getMessage());
	}
	
	@Test
	public void addRecipeInvalidNoOfPeople() throws RecipeException{
		RecipeDTO recipe=new RecipeDTO();
		recipe.setRecipeName("pizza");
		recipe.setIngredients("crust,cheese,toppings,veggies");
		recipe.setInstructions("1.Make your own pizza dough.2.Keep the sauce and toppings simple.3. Bake it hot.");
		recipe.setIsVegeterian(false);
		List<Recipe> recipes=new ArrayList<>();
		Mockito.when(recipeRepo.findAll()).thenReturn(recipes);
		RecipeException e=Assertions.assertThrows(RecipeException.class,()->recipeService.addRecipe(recipe));
		Assertions.assertEquals("Service.INVALID_DETAILS", e.getMessage());
	}
	
	@Test
	public void addRecipeInvalidIngredients() throws RecipeException{
		RecipeDTO recipe=new RecipeDTO();
		recipe.setRecipeName("pizza");
		recipe.setInstructions("1.Make your own pizza dough.2.Keep the sauce and toppings simple.3. Bake it hot.");
		recipe.setIsVegeterian(false);
		recipe.setNoOfPeople(8);
		List<Recipe> recipes=new ArrayList<>();
		Mockito.when(recipeRepo.findAll()).thenReturn(recipes);
		RecipeException e=Assertions.assertThrows(RecipeException.class,()->recipeService.addRecipe(recipe));
		Assertions.assertEquals("Service.INVALID_DETAILS", e.getMessage());
	}
	
	@Test
	public void addRecipeInvalidInstructions() throws RecipeException{
		RecipeDTO recipe=new RecipeDTO();
		recipe.setRecipeName("pizza");
		recipe.setIngredients("crust,cheese,toppings,veggies");
		recipe.setIsVegeterian(false);
		recipe.setNoOfPeople(8);
		List<Recipe> recipes=new ArrayList<>();
		Mockito.when(recipeRepo.findAll()).thenReturn(recipes);
		RecipeException e=Assertions.assertThrows(RecipeException.class,()->recipeService.addRecipe(recipe));
		Assertions.assertEquals("Service.INVALID_DETAILS", e.getMessage());
	}
	
	@Test
	public void addRecipeInvalidVegIndicator() throws RecipeException{
		RecipeDTO recipe=new RecipeDTO();
		recipe.setRecipeName("pizza");
		recipe.setIngredients("crust,cheese,toppings,veggies");
		recipe.setInstructions("1.Make your own pizza dough.2.Keep the sauce and toppings simple.3. Bake it hot.");
		recipe.setNoOfPeople(8);
		List<Recipe> recipes=new ArrayList<>();
		Mockito.when(recipeRepo.findAll()).thenReturn(recipes);
		RecipeException e=Assertions.assertThrows(RecipeException.class,()->recipeService.addRecipe(recipe));
		Assertions.assertEquals("Service.INVALID_DETAILS", e.getMessage());
	}
}
