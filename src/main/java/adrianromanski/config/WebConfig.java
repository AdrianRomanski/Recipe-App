package adrianromanski.config;

import adrianromanski.commands.UnitOfMeasureCommand;
import adrianromanski.domain.Recipe;
import adrianromanski.services.RecipeService;
import adrianromanski.services.UnitOfMeasureService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class WebConfig {

    @Bean
    public RouterFunction<?> recipes(RecipeService recipeService) {
        return RouterFunctions.route(GET("/api/recipes"),
                serverRequest -> ServerResponse
                                    .ok()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .body(recipeService.getRecipes(), Recipe.class));
    }

    @Bean
    public RouterFunction<?> unitsOfMeasure(UnitOfMeasureService unitOfMeasureService) {
        return RouterFunctions.route(GET("/api/unitsofmeasure"),
                serverRequest -> ServerResponse
                                        .ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .body(unitOfMeasureService.listAllUoms(), UnitOfMeasureCommand.class));

    }
}
