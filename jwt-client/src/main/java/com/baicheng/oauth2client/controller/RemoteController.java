package com.baicheng.oauth2client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author baicheng
 * @description
 * @create 2019-02-28 21:50
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class RemoteController {

    @Autowired
    private OAuth2RestOperations oAuth2RestOperations;

    @RequestMapping("/all")
    public ResponseEntity<String> getAllProducts(
            @RequestParam(value = "code", required = false) String code, @RequestParam(value = "state", required = false) String state
    ){
        log.info("[RemoteController getAllProducts] invoke log, code: {}, state: {}", code, state);

        String object = oAuth2RestOperations.getForObject("http://localhost:8002/product/all", String.class);

        log.info("[RemoteController getAllProducts] oAuth2RestOperations invoke, url: {}, resp: {}",
                "http://localhost:8002/product/all", object);

        return ResponseEntity.ok(object);
    }

}
