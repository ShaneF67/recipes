package com.samf.recipes.main.services.impl;

import com.samf.recipes.main.domain.Recipe;
import com.samf.recipes.main.repositories.RecipeRepository;
import com.samf.recipes.main.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getListOfRecipes() {
        log.debug("In getListOfRecipes in the Recipe Service");
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }
}
