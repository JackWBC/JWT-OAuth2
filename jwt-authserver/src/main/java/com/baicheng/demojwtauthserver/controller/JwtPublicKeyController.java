package com.baicheng.demojwtauthserver.controller;

import com.baicheng.demojwtauthserver.util.MyKeyPairUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

/**
 * @author baicheng
 * @description
 * @create 2019-03-22 21:12
 */
@RestController
@RequestMapping("/jwt")
public class JwtPublicKeyController {

    @Autowired
    private KeyPair jwtKeyPair;

    @GetMapping("/publicKey")
    public Map<String, String> getJwtPublicKey(){
        Map<String, String> map = new HashMap<>();
        String verifierKey = "-----BEGIN PUBLIC KEY-----\n" + MyKeyPairUtil.getPublicKey(jwtKeyPair)
                + "\n-----END PUBLIC KEY-----";
        map.put("value", verifierKey);
        return map;
    }
}
