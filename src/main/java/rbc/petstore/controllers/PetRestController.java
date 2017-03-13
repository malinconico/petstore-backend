package rbc.petstore.controllers;

import rbc.petstore.models.Pet;
import rbc.petstore.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import javax.servlet.*;

/**
 * Created by kaspernissen on 11/02/2016.
 */
@RestController

@RequestMapping("/pets")
public class PetRestController {

        @Autowired
        private PetRepository repository;

        @CrossOrigin
        @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<Collection<Pet>> getAllPets(){
            return new ResponseEntity<>((Collection<Pet>) repository.findAll(), HttpStatus.OK);
        }

        @CrossOrigin
        @RequestMapping(method = RequestMethod.GET, value = "/{id}")
        public ResponseEntity<Pet> getPetWithId(@PathVariable Long id) {
            return new ResponseEntity<>(repository.findOne(id),HttpStatus.OK);
        }

        @RequestMapping(method = RequestMethod.GET, params = {"name"})
        public ResponseEntity<Collection<Pet>> findPetWithName(@RequestParam(value="name") String name) {
            return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
        }

        @CrossOrigin
        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<?> addPet(@RequestBody Pet input) {
            return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
        }

        @CrossOrigin
        @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
      	public ResponseEntity<Void> deletePet(@PathVariable("id") Long id) {
          System.out.println("ok");
      		Pet pet = repository.findOne(id);
      		if (pet == null) {
      			//logger.debug("Employee with id " + id + " does not exists");
      			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
      		} else {
      			repository.delete(id);
      			//logger.debug("Employee with id " + id + " deleted");
      			return new ResponseEntity<Void>(HttpStatus.OK);
      		}
      	}

}
