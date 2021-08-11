package recipes;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class RecipeStorage {
    private final HashMap<Integer, Recipe> map;
    private static int idNum = 0;

    @Autowired
    public RecipeStorage(HashMap<Integer, Recipe> map) {
        this.map = map;
    }

    public ID addRecipe(Recipe recipe) {
        int id = ++idNum;
        recipe.setId(id);
        map.put(id, recipe);
        return new ID(recipe.getId());
    }

    public boolean hasRecipe(Integer id) {
        return map.containsKey(id);
    }

    public Recipe getRecipe(Integer id) {
        return map.get(id);
    }

    public boolean deleteRecipe(Integer id) {
        if (hasRecipe(id)) {
            map.remove(id);
            return true;
        } else {
            return false;
        }
    }

    @Data
    @AllArgsConstructor
    public class ID {
        private int id;

        public ID(Object id) {
        }
    }
}
