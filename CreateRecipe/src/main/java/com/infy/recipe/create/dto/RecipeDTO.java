package com.infy.recipe.create.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class RecipeDTO {
	private Integer recipeId;
	@Pattern(regexp="[A-Za-z][ A-Za-z]*[A-Za-z]",message="Recipe name should contain only alphabets and spaces, and shouldn't start or end with whitespaces")
	private String recipeName;
	private LocalDateTime time=LocalDateTime.now();
	private Boolean isVegeterian;
	@Min(value=1,message="Minimum number of people should be 1")
	private Integer noOfPeople;
	private String ingredients;
	private String instructions;
	
	public Integer getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public Boolean getIsVegeterian() {
		return isVegeterian;
	}
	public void setIsVegeterian(Boolean isVegeterian) {
		this.isVegeterian = isVegeterian;
	}
	public Integer getNoOfPeople() {
		return noOfPeople;
	}
	public void setNoOfPeople(Integer noOfPeople) {
		this.noOfPeople = noOfPeople;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	
}
