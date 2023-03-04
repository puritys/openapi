package com.puritys.spring.api;

import com.puritys.spring.model.*;
import com.puritys.spring.utils.TimeUtil;

import java.lang.RuntimeException;

import java.util.concurrent.Future;

import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.hc.client5.http.async.methods.SimpleRequestBuilder;
import org.apache.hc.client5.http.async.methods.SimpleRequestProducer;
import org.apache.hc.client5.http.async.methods.SimpleResponseConsumer;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.core5.http.HttpHost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserApiImpl implements UsersApiDelegate {

    @Inject CloseableHttpAsyncClient client;
    @Autowired TimeUtil timeUtil;

    @Override
    public ResponseEntity<User> getUser(String id) {
        User user = new User()
            .id(id)
            .name("John " + Long.toString(timeUtil.now()))
            .status(UserStatus.ACTIVE);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> createUser(User input) {
        try {
            final HttpHost target = new HttpHost("https", "www.google.com.tw", 443);
            final SimpleHttpRequest request = SimpleRequestBuilder.get()
                    .setHttpHost(target)
                    .setPath("/")
                    .build();

            Future<SimpleHttpResponse> future = client.execute(
                    SimpleRequestProducer.create(request),
                    SimpleResponseConsumer.create(), null);
            SimpleHttpResponse resp = future.get();
            log.info("get google homepage response = " + resp.getBodyText());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(new User(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> updateUser(String userId, UpdateUser input) {
        return new ResponseEntity<>(new User(), HttpStatus.OK);
    }


    public ResponseEntity<GeneralResponse> exception() {
        throw new RuntimeException("just error");
    }


}
