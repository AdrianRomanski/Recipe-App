package adrianromanski.services;

import adrianromanski.commands.RecipeCommand;
import adrianromanski.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(String l);

    RecipeCommand findCommandById(String l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(String idToDelete);
}
