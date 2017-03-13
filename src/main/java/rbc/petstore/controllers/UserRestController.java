package rbc.petstore.controllers;

import rbc.petstore.models.User;
import rbc.petstore.repositories.UserRepository;
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

@RequestMapping("/user")
public class UserRestController {

        @Autowired
        private UserRepository repository;

        @CrossOrigin
        @RequestMapping(method = RequestMethod.GET, params = {"name"})
        public ResponseEntity<Collection<User>> findUserWithName(@RequestParam(value="name") String name, @RequestParam(value="pass") String pass) {
            Collection<User> listUsers = repository.findByName(name);
            for(User user : listUsers)
            {
              System.out.println('@' + user.getPass() + '@' + pass + '@');
              if (user.getPass().equals(pass))
              {
                System.out.println("ok");
                return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
              }

            }
              System.out.println("nok");
              return new ResponseEntity<>(repository.findByName("notfound"), HttpStatus.FORBIDDEN);

        }


        @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<Collection<User>> getAllUsers(){
            return new ResponseEntity<>((Collection<User>) repository.findAll(), HttpStatus.OK);
        }


}
