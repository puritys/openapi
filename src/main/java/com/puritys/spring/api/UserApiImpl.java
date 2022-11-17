package com.puritys.spring.api;

import com.puritys.spring.api.UsersApiDelegate;
import com.puritys.spring.model.*;
import com.puritys.spring.model.GeneralResponse;

import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import springfox.documentation.annotations.ApiIgnore;
import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.hc.client5.http.async.methods.SimpleRequestBuilder;
import org.apache.hc.client5.http.async.methods.SimpleRequestProducer;
import org.apache.hc.client5.http.async.methods.SimpleResponseConsumer;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
import org.apache.hc.client5.http.ssl.ClientTlsStrategyBuilder;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.message.StatusLine;
import org.apache.hc.core5.http.nio.ssl.TlsStrategy;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.reactor.IOReactorConfig;
import org.apache.hc.core5.util.Timeout;
import java.util.concurrent.Future;
import java.lang.RuntimeException;

@Slf4j
@Service
public class UserApiImpl implements UsersApiDelegate {

    @Autowired CloseableHttpAsyncClient client;

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
            System.out.println("get google homepage response = " + resp.getBodyText());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(new User(), HttpStatus.OK);
    }

}
