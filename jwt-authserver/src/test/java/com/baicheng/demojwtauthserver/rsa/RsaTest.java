package com.baicheng.demojwtauthserver.rsa;

import com.baicheng.demojwtauthserver.DemoJwtAuthserverApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 * @author baicheng
 * @description
 * @create 2019-03-22 20:21
 */
@Slf4j
public class RsaTest extends DemoJwtAuthserverApplicationTests {

    @Test
    public void testRsa() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        byte[] publicKey = keyPair.getPublic().getEncoded();
        log.info("Public key {}", Base64.encodeBase64String(publicKey));

        byte[] privateKey = keyPair.getPrivate().getEncoded();
        log.info("Private key {}", Base64.encodeBase64String(privateKey));

        log.info("----------------------");

        log.info("Public key format: {}", keyPair.getPublic().getFormat());
        log.info("Private key format: {}", keyPair.getPrivate().getFormat());

        log.info("----------------------");

        log.info("Public key algorithm: {}", keyPair.getPublic().getAlgorithm());
        log.info("Private key algorithm: {}", keyPair.getPrivate().getAlgorithm());
    }
}
