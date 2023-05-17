package com.bjit.SpringSecurity.service;

import com.bjit.SpringSecurity.model.UserRequestModel;
import com.bjit.SpringSecurity.model.UserResponseModel;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> register(UserRequestModel requestModel);
}
