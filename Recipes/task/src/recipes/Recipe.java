package recipes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe {

    @Id
    @JsonIgnore
    private int id;

    @Column
    private final String name = "default name";

    @Column
    private final String description = "default description";

    @Column
    private final String[] ingredients = {"default ingredients"};

    @Column
    private final String[] directions = {"default directions"};

}
