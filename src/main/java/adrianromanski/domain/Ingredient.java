package adrianromanski.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Ingredient {

    private String id;
    private String description;
    private BigDecimal amount;
    private Recipe recipe;
    private UnitOfMeasure uom;

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
        this.description = description;
        this.amount = amount;
        this.uom = unitOfMeasure;
    }


}
