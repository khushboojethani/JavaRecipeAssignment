package com.infy.recipe.get.dto;

import java.time.LocalDateTime;

public class RecipeDTO {
	private Integer recipeId;
	private String recipeName;
	private LocalDateTime time=LocalDateTime.now();
	private Boolean isVegeterian;
	private Integer noOfPeople;
	private String[] ingredients;
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
	
	public String[] getIngredients() {
		return ingredients;
	}
	public void setIngredients(String[] ingredients) {
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
