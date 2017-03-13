package rbc.petstore.repositories;

import rbc.petstore.models.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PetRepository extends CrudRepository<Pet, Long> {
    List<Pet> findByName(String name);
}
