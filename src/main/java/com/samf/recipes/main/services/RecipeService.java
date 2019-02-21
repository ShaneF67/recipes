package com.samf.recipes.main.services;

import com.samf.recipes.main.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getListOfRecipes();
}
