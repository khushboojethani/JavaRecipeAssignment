package com.example.demo;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.recipe.delete.entity.Recipe;
import com.infy.recipe.delete.exception.RecipeException;
import com.infy.recipe.delete.repository.RecipeRepository;
import com.infy.recipe.delete.service.DeleteRecipeImpl;

@SpringBootTest(classes= {DeleteRecipeApplicationTests.class})
class DeleteRecipeApplicationTests {


	@Mock
	RecipeRepository recipeRepo;
	
	@InjectMocks
	DeleteRecipeImpl deleteService;
	
	@Test
	public void deleteValidTest() throws RecipeException{
		Recipe recipe=new Recipe();
		recipe.setRecipeId(1);
		Mockito.when(recipeRepo.findById(recipe.getRecipeId())).thenReturn(Optional.of(recipe));
		Assertions.assertEquals("Recipe deleted for recipe Id:"+recipe.getRecipeId(),deleteService.deleteRecipe(1));
	}
	
	@Test
	public void deleteInvalidTest() throws RecipeException{
		Recipe recipe=new Recipe();
		recipe.setRecipeId(1);
		Mockito.when(recipeRepo.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		RecipeException e=Assertions.assertThrows(RecipeException.class,()->deleteService.deleteRecipe(1));
		Assertions.assertEquals("Service.RECIPE_NOT_FOUND",e.getMessage());
	}
}
