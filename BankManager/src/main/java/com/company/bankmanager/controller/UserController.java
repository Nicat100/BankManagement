package com.company.bankmanager.controller;

import com.company.bankmanager.dto.UserDto;
import com.company.bankmanager.service.inter.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping ("/create")
    public void create(@RequestBody UserDto user){
        userService.create(user);
    }

    @GetMapping("/finduser/{id}")
    public UserDto findUser(@PathVariable int id){
        return userService.findById(id);
    }

    @GetMapping("/getallusers")
    public List<UserDto> getAllUser(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/deleteuser/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }
}
