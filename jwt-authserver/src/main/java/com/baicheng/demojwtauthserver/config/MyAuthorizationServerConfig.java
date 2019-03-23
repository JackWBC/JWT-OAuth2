package com.baicheng.demojwtauthserver.config;

import com.baicheng.demojwtauthserver.service.MyUserDetailsService;
import com.baicheng.demojwtauthserver.util.MyKeyPairUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

/**
 * @author baicheng
 * @description
 * @create 2019-03-10 19:14
 */
@Configuration
@EnableAuthorizationServer
@Slf4j
public class MyAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource oauth2DataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public ClientDetailsService myClientDetailsService(){
        return new JdbcClientDetailsService(oauth2DataSource());
    }

    @Bean
    public KeyPair jwtKeyPair(){
        KeyPair keyPair = MyKeyPairUtil.gennerateKeyPair("RSA");
        log.info("------------ JWT KeyPair -------------");
        log.info("Public key: {}", MyKeyPairUtil.getPublicKey(keyPair));
        log.info("Private key: {}", MyKeyPairUtil.getPrivateKey(keyPair));
        log.info("------------     end     -------------");
        return keyPair;
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() throws NoSuchAlgorithmException {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();

//        asymmetric encryption 非对称加密
        KeyPair keyPair = jwtKeyPair();
        converter.setKeyPair(keyPair);

//        symmetrical encryption 对称加密
//        converter.setSigningKey("secret");

        return converter;
    }

    @Bean
    public JwtTokenStore jwtTokenStore() throws NoSuchAlgorithmException {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(myClientDetailsService());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
        security.checkTokenAccess("permitAll()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)
                .userDetailsService(myUserDetailsService)
                .tokenStore(jwtTokenStore())
                .accessTokenConverter(jwtAccessTokenConverter());
    }
}
