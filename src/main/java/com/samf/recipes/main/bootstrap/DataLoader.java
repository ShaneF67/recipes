package com.samf.recipes.main.bootstrap;

import com.samf.recipes.main.domain.*;
import com.samf.recipes.main.repositories.CategoryRepository;
import com.samf.recipes.main.repositories.RecipeRepository;
import com.samf.recipes.main.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadGuacRecipe();
        loadSpicyChickenTacos();
    }

    private void loadSpicyChickenTacos() {
        log.debug("Starting to load Spicy Chicken Recipe");
        UnitOfMeasure unit = unitOfMeasureRepository.findByDescription("Unit").get();
        UnitOfMeasure teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();
        UnitOfMeasure tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();
        UnitOfMeasure cup = unitOfMeasureRepository.findByDescription("Cup").get();
        UnitOfMeasure pint = unitOfMeasureRepository.findByDescription("Pint").get();

        Recipe tacosRecipe = new Recipe();

        tacosRecipe.setDescription("Spicy Grilled Chicken Tacos Recipe");
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setCookTime(15);
        tacosRecipe.setDifficulty(Difficulty.EASY);
        tacosRecipe.setServings(4);

        Category category = categoryRepository.findByDescription("Mexican").get();
        Set<Category> categories = new HashSet<>();
        categories.add(category);
        tacosRecipe.setCategories(categories);

        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");
        tacosRecipe.setNotes(tacoNotes);

        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(2), "Ancho Chili Powder", tablespoon));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(1), "Dried Oregano", teaspoon));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(1), "Dried Cumin", teaspoon));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(1), "Sugar", teaspoon));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(0.5), "Salt", teaspoon));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(1), "Clove of Garlic", unit));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(1), "Finely Grated Orange Zest", tablespoon));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(3), "Fresh-Squeezed Orange Juice", tablespoon));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(2), "Olive Oil", tablespoon));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(6), "Skinless, Boneless Chicken Thighs", unit));

        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(8), "Small Corn Tortillas", unit));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(3), "Packed Baby Arugala", cup));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(2), "Medium Ripe Avocados", unit));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(4), "Thinly Sliced Radishes", unit));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(0.5), "Cherry Tomatoes - Halved", pint));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(0.25), "Red Onion Thinly Sliced", unit));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(1), "Roughly Chopped Cilantro", unit));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(0.5), "Sour Cream", cup));
        tacosRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(1), "Lime Cut into Wedges", unit));

        recipeRepository.save(tacosRecipe);

        log.debug("Finished loading Spicy Chicken Recipe");

    }

    private void loadGuacRecipe() {
        log.debug("Starting to load Guacamole Recipe");

        UnitOfMeasure unit = unitOfMeasureRepository.findByDescription("Unit").get();
        UnitOfMeasure teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();
        UnitOfMeasure tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();
        UnitOfMeasure dash = unitOfMeasureRepository.findByDescription("Pinch").get();

        Recipe guacRecipe = new Recipe();

        guacRecipe.setDescription("How to Make Perfect Guacamole Recipe");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setServings(4);

        Category category = categoryRepository.findByDescription("Mexican").get();
        Set<Category> categories = new HashSet<>();
        categories.add(category);
        guacRecipe.setCategories(categories);

        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");

        guacRecipe.setNotes(guacNotes);


        guacRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(2), "Ripe Avocados", unit));
        guacRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(0.5), "Kosher Saalt", teaspoon));
        guacRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(1), "Lime or Lemon Juice", tablespoon));
        guacRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(2), "Minced Red Onion", tablespoon));
        guacRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(1), "Serrano Chillies", unit));
        guacRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(2), "Coriander", tablespoon));
        guacRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(1), "Freshly Ground Black Pepper", dash));
        guacRecipe.addIngredients(new Ingredient (BigDecimal.valueOf(0.5), "Ripe, chopped tomato with the seeds and pulp removed.", unit));

        recipeRepository.save(guacRecipe);
        log.debug("Finished loading Guacamole Recipe");

    }

}
