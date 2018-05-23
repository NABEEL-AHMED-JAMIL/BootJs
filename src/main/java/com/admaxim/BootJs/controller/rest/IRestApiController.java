package com.admaxim.BootJs.controller.rest;


import com.admaxim.BootJs.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RequestMapping(value = "/api")
public interface IRestApiController {

    //----------------Retrieve All User---------
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers();

    //----------------Retrieve Single User---------
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> findUserbyId(@PathVariable("userId") Long userId);

    //---------------Create a User----------------
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder);

    // ------------------- Update a User ------------------------------------------------
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("userId") Long userId, @RequestBody User user);

    // ------------------- DeleteaUser-----------------------------------------
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserbyId(@PathVariable("userId") Long userId);

    // ------------------- Delete All Users-----------------------------
    @RequestMapping(value = "/user/deletes", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers();

}
