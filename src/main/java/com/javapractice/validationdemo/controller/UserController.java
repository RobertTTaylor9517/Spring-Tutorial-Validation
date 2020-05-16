package com.javapractice.validationdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import com.javapractice.validationdemo.dao.UserDAO;
import com.javapractice.validationdemo.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping
    public List<User> getUsers() {
        return userDAO.findAll();
    }

    @GetMapping(value = "/{id}")
    public Object getUserById(@PathVariable("id") UUID id) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("error", "User Not Found");

        Optional<User> user = userDAO.findById(id);

        if(user.isPresent()){
            return user.get();

        }else{
            return response;
        }
    }

    @PostMapping
    public Object addUser(@Valid @RequestBody User newUser, BindingResult result){
        if(result.hasErrors()){
            return result.getAllErrors();
        }

        User user = userDAO.save(newUser);

        return user;
    }
    
    @PutMapping
    public Object updateUser(@Valid @RequestBody User newUser, BindingResult result){
        User user = userDAO.getOne(newUser.getId());

        if(result.hasErrors()){
            return result.getAllErrors();
        }

        user = newUser;

        return userDAO.save(user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable("id") UUID id){
        userDAO.deleteById(id);
    }
}