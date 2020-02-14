package adrianromanski.domain;

import javax.persistence.*;

@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnitOfMeasure() {
        return description;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.description = unitOfMeasure;
    }
}

