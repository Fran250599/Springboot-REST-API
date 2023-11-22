package com.francisco.crud.controller;

import com.francisco.crud.model.User;
import com.francisco.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getUserById( @PathVariable Long id){
        return userService.getUserById(id);
    }

    // Login user
    @PostMapping(path = "/login")
    public ResponseEntity<Object> loginUser(@RequestBody User user){
        return userService.loginUser(user);
    }


    @PostMapping

    public ResponseEntity<Object> registerUser(@RequestBody User user){
        return userService.newUser(user);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
