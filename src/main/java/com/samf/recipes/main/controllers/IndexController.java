package com.samf.recipes.main.controllers;

import com.samf.recipes.main.domain.Category;
import com.samf.recipes.main.domain.UnitOfMeasure;
import com.samf.recipes.main.repositories.CategoryRepository;
import com.samf.recipes.main.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");


        System.out.println("Cat ID is : " + categoryOptional.get().getId());
        System.out.println("UOM ID is: " + uomOptional.get().getId());
        return "index";
    }


}
