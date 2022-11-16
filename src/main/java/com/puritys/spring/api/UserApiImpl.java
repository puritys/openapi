package com.puritys.spring.api;

import com.puritys.spring.api.UsersApiDelegate;
import com.puritys.spring.model.*;
import com.puritys.spring.model.GeneralResponse;

import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import springfox.documentation.annotations.ApiIgnore;

@Slf4j
@Service
public class UserApiImpl implements UsersApiDelegate {

    @Override
    public ResponseEntity<User> getUser(String id) {
        List<String> fields = Arrays.asList("nickname");
        User user = new User()
            .id(id)
            .name("John")
            .status(UserStatus.ACTIVE);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> createUser(User input) {
        return new ResponseEntity<>(new User(), HttpStatus.OK);
    }

}
