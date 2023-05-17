package com.bjit.SpringSecurity.controllers;

import com.bjit.SpringSecurity.model.UserRequestModel;
import com.bjit.SpringSecurity.model.UserResponseModel;
import com.bjit.SpringSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor                       //no auto wiring needed
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserRequestModel requestModel) {
        return userService.register(requestModel);
//        return userService.response(requestModel);
    }


}


