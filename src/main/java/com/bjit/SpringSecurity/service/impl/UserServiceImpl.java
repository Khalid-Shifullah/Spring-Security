package com.bjit.SpringSecurity.service.impl;

import com.bjit.SpringSecurity.entity.UserEntity;
import com.bjit.SpringSecurity.model.UserRequestModel;
import com.bjit.SpringSecurity.model.UserResponseModel;
import com.bjit.SpringSecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.bjit.SpringSecurity.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Object> register(UserRequestModel requestModel) {
        UserEntity userEntity = UserEntity.builder()
                .email(requestModel.getEmail())
                .userName(requestModel.getUserName())
                .firstName(requestModel.getFirstName())
                .lastName(requestModel.getLastName())
                .password(passwordEncoder.encode(requestModel.getPassword()))
                .build();
        UserEntity savedUserEntity = userRepository.save(userEntity);

        //Populating response model
        UserResponseModel userResponseModel = new UserResponseModel(savedUserEntity.getUserName(), savedUserEntity.getFirstName(), savedUserEntity.getLastName(), savedUserEntity.getEmail());

        return new ResponseEntity<>(userResponseModel, HttpStatus.CREATED);
    }

}
