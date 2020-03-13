package adrianromanski.controllers;


import adrianromanski.commands.UnitOfMeasureCommand;
import adrianromanski.config.WebConfig;
import adrianromanski.domain.Recipe;
import adrianromanski.services.RecipeService;
import adrianromanski.services.UnitOfMeasureService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;


public class RouterFunctionTest {

    WebTestClient webTestClientRecipes;

    WebTestClient webTestClientUoms;

    @Mock
    RecipeService recipeService;

    @Mock
    UnitOfMeasureService unitOfMeasureService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        WebConfig webConfig = new WebConfig();

        RouterFunction<?> recipesRouterFunction = webConfig.recipes(recipeService);

        RouterFunction<?> uomsRouterFunction = webConfig.unitsOfMeasure(unitOfMeasureService);

        webTestClientRecipes = WebTestClient.bindToRouterFunction(recipesRouterFunction).build();

        webTestClientUoms = WebTestClient.bindToRouterFunction(uomsRouterFunction).build();

    }


    @Test
    public void testGetRecipes() throws Exception {

        when(recipeService.getRecipes()).thenReturn(Flux.just());

        webTestClientRecipes.get().uri("/api/recipes")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testGetRecipesWithData() throws Exception {

        when(recipeService.getRecipes()).thenReturn(Flux.just(new Recipe(), new Recipe()));

        webTestClientRecipes.get().uri("/api/recipes")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Recipe.class);
    }

    @Test
    public void testGetUoms() throws Exception {

        when(unitOfMeasureService.listAllUoms()).thenReturn(Flux.just());

        webTestClientUoms.get().uri("/api/unitsofmeasure")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testGetUomsWithData() throws Exception {
        when(unitOfMeasureService.listAllUoms()).thenReturn(Flux.just(new UnitOfMeasureCommand(), new UnitOfMeasureCommand()));

        webTestClientUoms.get().uri("/api/unitsofmeasure")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(UnitOfMeasureCommand.class);
    }
}

