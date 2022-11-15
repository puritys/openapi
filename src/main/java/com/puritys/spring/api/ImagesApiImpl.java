package com.puritys.spring.api;

import com.puritys.spring.model.GeneralResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ImagesApiImpl implements ImagesApiDelegate {

    @Override
    public ResponseEntity<GeneralResponse> getImage(String id) {
        return new ResponseEntity<>(new GeneralResponse(), HttpStatus.OK);
    }

}
