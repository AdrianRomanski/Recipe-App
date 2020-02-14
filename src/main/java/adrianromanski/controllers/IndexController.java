package adrianromanski.controllers;

import adrianromanski.domain.Category;
import adrianromanski.domain.UnitOfMeasure;
import adrianromanski.repositories.CategoryRepository;
import adrianromanski.repositories.UnitOfMeasureRepository;
import adrianromanski.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

   private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

       model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
