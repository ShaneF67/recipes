package com.samf.recipes.main.repositories;

import com.samf.recipes.main.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
