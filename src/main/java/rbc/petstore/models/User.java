package rbc.petstore.models;


import javax.persistence.*;

/**
 * Created by kaspernissen on 11/02/2016.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String pass;

    public User(String name) {
        this.name = name;
    }

    //for JPA
    public User() {}

    public String getUser() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public Long getId() {
        return id;
    }
}
