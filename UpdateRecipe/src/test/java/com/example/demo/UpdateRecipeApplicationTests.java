package com.example.demo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.recipe.update.entity.Recipe;
import com.infy.recipe.update.exception.RecipeException;
import com.infy.recipe.update.repository.RecipeRepository;
import com.infy.recipe.update.service.UpdateRecipe;
import com.infy.recipe.update.service.UpdateRecipeImpl;

@SpringBootTest(classes= {UpdateRecipeApplicationTests.class})
class UpdateRecipeApplicationTests {

	@Mock
	RecipeRepository recipeRepo;
	
	@InjectMocks
	UpdateRecipe updateService=new UpdateRecipeImpl();
	
	@Test
	public void updatePeopleValidTest() throws RecipeException{
		Recipe recipe=new Recipe();
		recipe.setRecipeId(1);
		recipe.setNoOfPeople(5);
		Mockito.when(recipeRepo.findById(recipe.getRecipeId())).thenReturn(Optional.of(recipe));
		Assertions.assertEquals("No. of people updated to "+8+" for Recipe Id : "+recipe.getRecipeId(),updateService.updatePeople(recipe.getRecipeId(),8));
	}
	
	@Test
	public void updatePeopleInvalidTest() throws RecipeException{
		Recipe recipe=new Recipe();
		recipe.setRecipeId(1);
		Mockito.when(recipeRepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		RecipeException e=Assertions.assertThrows(RecipeException.class,()->updateService.updatePeople(recipe.getRecipeId(),10));
		Assertions.assertEquals("Service.RECIPE_NOT_FOUND",e.getMessage());
	}

	@Test
	public void updateNameValidTest() throws RecipeException{
		Recipe recipe=new Recipe();
		recipe.setRecipeId(1);
		recipe.setRecipeName("pasta");
		Mockito.when(recipeRepo.findById(recipe.getRecipeId())).thenReturn(Optional.of(recipe));
		Assertions.assertEquals("Recipe name updated to "+"taco"+" for Recipe Id : "+recipe.getRecipeId(),updateService.updateName(recipe.getRecipeId(),"taco"));
	}
	
	@Test
	public void updateNameInvalidTest() throws RecipeException{
		Recipe recipe=new Recipe();
		recipe.setRecipeId(1);
		Mockito.when(recipeRepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		RecipeException e=Assertions.assertThrows(RecipeException.class,()->updateService.updateName(recipe.getRecipeId(),"pasta"));
		Assertions.assertEquals("Service.RECIPE_NOT_FOUND",e.getMessage());
	}
	
	@Test
	public void updateTimeValidTest() throws RecipeException{
		Recipe recipe=new Recipe();
		recipe.setRecipeId(1);
		recipe.setTime(LocalDateTime.of(2015, 02, 20, 0, 0));
		Mockito.when(recipeRepo.findById(recipe.getRecipeId())).thenReturn(Optional.of(recipe));
		Assertions.assertEquals("Time updated to " +LocalDateTime.of(2016, 02, 20, 0, 0)+" for Recipe Id : "+recipe.getRecipeId(),updateService.updateTime(recipe.getRecipeId(),LocalDateTime.of(2016, 02, 20, 0, 0)));
	}
	
	@Test
	public void updateTimeInvalidTest() throws RecipeException{
		Recipe recipe=new Recipe();
		recipe.setRecipeId(1);
		Mockito.when(recipeRepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		RecipeException e=Assertions.assertThrows(RecipeException.class,()->updateService.updateTime(recipe.getRecipeId(),LocalDateTime.of(2016, 02, 20, 0, 0)));
		Assertions.assertEquals("Service.RECIPE_NOT_FOUND",e.getMessage());
	}
	
	@Test
	public void updateVegIndicatorValidTest() throws RecipeException{
		Recipe recipe=new Recipe();
		recipe.setRecipeId(1);
		recipe.setIsVegeterian(true);
		Mockito.when(recipeRepo.findById(recipe.getRecipeId())).thenReturn(Optional.of(recipe));
		Assertions.assertEquals("Veg indicator updated to "+false+" for Recipe Id : "+recipe.getRecipeId(),updateService.updateVeg(recipe.getRecipeId(),false));
	}
	
	@Test
	public void updateVegIndicatorInvalidTest() throws RecipeException{
		Recipe recipe=new Recipe();
		recipe.setRecipeId(1);
		Mockito.when(recipeRepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		RecipeException e=Assertions.assertThrows(RecipeException.class,()->updateService.updateVeg(recipe.getRecipeId(),true));
		Assertions.assertEquals("Service.RECIPE_NOT_FOUND",e.getMessage());
	}
	
	@Test
	public void updateIngredientsValidTest() throws RecipeException{
		Recipe recipe=new Recipe();
		recipe.setRecipeId(1);
		recipe.setIngredients("tomato,onions,potato");
		Mockito.when(recipeRepo.findById(recipe.getRecipeId())).thenReturn(Optional.of(recipe));
		Assertions.assertEquals("Ingredients updated to "+"onions,potato"+" for Recipe Id : "+recipe.getRecipeId(),updateService.updateIngredients(recipe.getRecipeId(),"onions,potato"));
	}
	
	@Test
	public void updateIngredientsInvalidTest() throws RecipeException{
		Recipe recipe=new Recipe();
		recipe.setRecipeId(1);
		Mockito.when(recipeRepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		RecipeException e=Assertions.assertThrows(RecipeException.class,()->updateService.updateIngredients(recipe.getRecipeId(),"potatoes,tomato,onions"));
		Assertions.assertEquals("Service.RECIPE_NOT_FOUND",e.getMessage());
	}
	
	@Test
	public void updateInstructionsValidTest() throws RecipeException{
		Recipe recipe=new Recipe();
		recipe.setRecipeId(1);
		recipe.setInstructions("cut onions and potatoes, fry them.");
		Mockito.when(recipeRepo.findById(recipe.getRecipeId())).thenReturn(Optional.of(recipe));
		Assertions.assertEquals("Instructions updated to "+"cut onions, boil potatoes"+" for Recipe Id : "+recipe.getRecipeId(),updateService.updateInstructions(recipe.getRecipeId(),"cut onions, boil potatoes"));
	}
	
	@Test
	public void updateInstructionsInvalidTest() throws RecipeException{
		Recipe recipe=new Recipe();
		recipe.setRecipeId(1);
		Mockito.when(recipeRepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		RecipeException e=Assertions.assertThrows(RecipeException.class,()->updateService.updateInstructions(recipe.getRecipeId(),"cut onions, boil potatoes"));
		Assertions.assertEquals("Service.RECIPE_NOT_FOUND",e.getMessage());
	}
}
