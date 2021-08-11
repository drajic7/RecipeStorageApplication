package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;

@RestController
public class RecipeController {
    private RecipeStorage recipeStorage;

    @Autowired
    public RecipeController(RecipeStorage recipeRepository) {
        this.recipeStorage = recipeRepository;
    }

    @GetMapping("/api/recipe/{id}")
    public Recipe getRecipe(@PathVariable int id) {
        if (!recipeStorage.hasRecipe(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe not found");
        }
        return recipeStorage.getRecipe(id);
    }

    @PostMapping("/api/recipe/new")
    public ResponseEntity<RecipeStorage.ID> postRecipe(@RequestBody Recipe r) {
        RecipeStorage.ID id = recipeStorage.addRecipe(r);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/api/recipe/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable int id) {
        if (recipeStorage.deleteRecipe(id))
            return new ResponseEntity<>("Recipe deleted", HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>("Recipe not Found", HttpStatus.NOT_FOUND);
    }

}
