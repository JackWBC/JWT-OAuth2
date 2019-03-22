package com.baicheng.demojwtauthserver.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

/**
 * @author baicheng
 * @description
 * @create 2019-03-22 20:44
 */
@Slf4j
public class MyKeyPairUtil {

    public static KeyPair gennerateKeyPair(String algorithm){
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            return keyPairGenerator.generateKeyPair();
        } catch (Exception e){
            log.error("[MyKeyPairUtil gennerateKeyPair] error, algorithm: {}, exception:{}", algorithm, e.toString());
            return null;
        }
    }

    public static String getPublicKey(KeyPair keyPair){
        if (checkPublic(keyPair)){
            return null;
        }
        byte[] publicKeyEncoded = keyPair.getPublic().getEncoded();
        return Base64.encodeBase64String(publicKeyEncoded);
    }

    public static String getPrivateKey(KeyPair keyPair){
        if (checkPrivate(keyPair)){
            return null;
        }
        byte[] privateKeyEncoded = keyPair.getPrivate().getEncoded();
        return Base64.encodeBase64String(privateKeyEncoded);
    }

    public static String getAlgorithm(KeyPair keyPair){
        if (checkPublic(keyPair)){
            return null;
        }
        return keyPair.getPublic().getAlgorithm();
    }

    public static String getPublicKeyFormat(KeyPair keyPair){
        if (checkPublic(keyPair)){
            return null;
        }
        return keyPair.getPublic().getFormat();
    }

    public static String getPrivateKeyFormat(KeyPair keyPair){
        if (checkPrivate(keyPair)){
            return null;
        }
        return keyPair.getPrivate().getFormat();
    }

    private static boolean checkPublic(KeyPair keyPair){
        return keyPair == null || keyPair.getPublic() == null;
    }

    private static boolean checkPrivate(KeyPair keyPair){
        return keyPair == null || keyPair.getPrivate() == null;
    }
}
