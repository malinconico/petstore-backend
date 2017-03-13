package rbc.petstore.models;


import javax.persistence.*;

/**
 * Created by kaspernissen on 11/02/2016.
 */
@Entity
@Table(name = "newpet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String status;

    public Pet(String name) {
        this.name = name;
        this.status = "Available";
    }

    //for JPA
    public Pet() {}

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }
}
