package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/search/{username}")
    public ResponseEntity<List<User>> findByUserName(@PathVariable("username") String username) {
        Optional<User> userList = userService.findByUsername(username);
        return new ResponseEntity(userList, HttpStatus.OK);
    }

//    @GetMapping("/search/")
//    public ResponseEntity<List<User>> findAllFriendCommon(){
//        Optional<User> friendsCommon = userService.findByUsername();
//
//        return new ResponseEntity(friendsCommon ,HttpStatus.OK);
//    }
}
