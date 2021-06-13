package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.recipe.get.dto.RecipeDTO;
import com.infy.recipe.get.entity.Recipe;
import com.infy.recipe.get.exception.RecipeException;
import com.infy.recipe.get.repository.RecipeRepository;
import com.infy.recipe.get.service.GetRecipeImpl;

@SpringBootTest(classes = { GetRecipeApplicationTests.class })
class GetRecipeApplicationTests {

	@Mock
	RecipeRepository recipeRepo;
	
	@InjectMocks
	GetRecipeImpl getServiceImpl;
	
	@Test
	public void getValidRecipes() throws RecipeException {
		List<Recipe> recipes=new ArrayList<>();
		Recipe rec=new Recipe();
		rec.setRecipeName("pizza");
		rec.setRecipeId(1);
		rec.setIngredients("crust,cheese,toppings,veggies");
		rec.setInstructions("1.Make your own pizza dough.2.Keep the sauce and toppings simple.3. Bake it hot.");
		rec.setIsVegeterian(false);
		rec.setNoOfPeople(8);
		recipes.add(rec);
		List<RecipeDTO> recipeList=new ArrayList<>();
		recipes.forEach(recipe->{
			RecipeDTO rdto=new RecipeDTO();
			rdto.setRecipeId(recipe.getRecipeId());
			rdto.setRecipeName(recipe.getRecipeName());
			rdto.setNoOfPeople(recipe.getNoOfPeople());
			String[] in=recipe.getIngredients().split(",");
			rdto.setIngredients(in);
			rdto.setInstructions(recipe.getInstructions());
			recipeList.add(rdto);
		});
		Mockito.when(recipeRepo.findAll()).thenReturn(recipes);
		Assertions.assertEquals(recipeList.get(0).getRecipeId(),getServiceImpl.getAll().get(0).getRecipeId());
	}
	
	@Test
	public void getInvalidrecipes() throws RecipeException{
		List<Recipe> recipes=new ArrayList<>();
		Mockito.when(recipeRepo.findAll()).thenReturn(recipes);
		RecipeException e=Assertions.assertThrows(RecipeException.class,()->getServiceImpl.getAll());
		Assertions.assertEquals("Service.NO_RECIPES_FOUND",e.getMessage());
	}
}
