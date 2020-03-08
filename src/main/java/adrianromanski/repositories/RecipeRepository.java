package adrianromanski.repositories;

import adrianromanski.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, String> {
}
