package com.RCTR.usersys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RCTR.usersys.model.User;
import com.RCTR.usersys.service.UserService;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    
private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

@PostMapping("/user")
public User saveUser(@RequestBody User user){
    return userService.saveUser(user);
}

@GetMapping("/users")
public List<User> getAllUsers(){
    List<User> users = userService.getAllUsers();
    System.out.println("Users from service: " + users);
    return users;
       // return userService.getAllUsers();
}

@GetMapping("/users/{id}")
public ResponseEntity<User> getUserById(@PathVariable("id")Long id){
    User user = null;
    user = userService.getUserById(id);
    return ResponseEntity.ok(user);
}

@DeleteMapping("/users/{id}")
public ResponseEntity<Map<String , Boolean>> deleteUser(@PathVariable("id")Long id){
boolean deleted = false;
deleted = userService.deleteUser(id);
Map<String,Boolean> response = new HashMap<>();
 if (deleted) {
        response.put("deleted", true);
        return ResponseEntity.ok(response);
    } else {
        response.put("deleted", false);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}

@PutMapping("/users/{id}")
public ResponseEntity<User> updateUser(@PathVariable("id")Long id,@RequestBody User user){
user = userService.updateUser(id,user);
    return ResponseEntity.ok(user);
}

}
