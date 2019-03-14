package com.samf.recipes.main.controllers;

import com.samf.recipes.main.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {


    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("In index method of IndexController");
        model.addAttribute("recipes", recipeService.getListOfRecipes());
        return "index";
    }

}
