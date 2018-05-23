package com.admaxim.BootJs.controller.rest;

import com.admaxim.BootJs.model.User;
import com.admaxim.BootJs.service.IUserService;
import com.admaxim.BootJs.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

@RestController
public class RestApiController implements IRestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    private IUserService iUserService;


    @Override
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = iUserService.findAllUsers();
        if(users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findUserbyId(@PathVariable("userId") Long userId) {
        logger.info("Fetching User wiht userid {}", userId);
        Optional<User> user = iUserService.findById(userId);
        if(!user.isPresent()) {
            logger.error("User with userId {} not found.", userId);
            return new ResponseEntity<>(
                    new CustomErrorType("User with userId " + userId + " not found"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
        logger.info("Creating User : {}", user);
        if(iUserService.isUserExist(user)) {
            logger.error("Unable to create. A User with name {} already exist", user.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " +
                    user.getName() + " already exist."),HttpStatus.CONFLICT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.
                path("/api/user/{userId}").buildAndExpand(iUserService.saveUser(user).getUserId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateUser(@PathVariable("userId") Long userId, @RequestBody User user) {
        logger.info("Updating User with userId {}", userId);

        Optional<User> currentUser = iUserService.findById(userId);

        if(!currentUser.isPresent()) {
            logger.error("Unable to update. User with userId {} not found.", userId);
            return new ResponseEntity(new CustomErrorType("Unable to upate. User with userId " + userId + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentUser.get().setName(user.getName());
        currentUser.get().setAge(user.getAge());
        currentUser.get().setSalary(user.getSalary());
        iUserService.updateUser(currentUser.get());

        return new ResponseEntity<User>(currentUser.get(), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> deleteUserbyId(@PathVariable("userId") Long userId) {
        logger.info("Fetching & Deleting User with userId {}", userId);

        Optional<User> user = iUserService.findById(userId);

        if (!user.isPresent()) {
            logger.error("Unable to delete. User with userId {} not found.", userId);
            return new ResponseEntity(
                    new CustomErrorType("Unable to delete. User with userId " + userId + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        iUserService.deleteUserById(userId);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<User> deleteAllUsers() {
        logger.info("Deleting All Users");
        iUserService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}
