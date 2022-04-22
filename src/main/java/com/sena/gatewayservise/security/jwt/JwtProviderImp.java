package com.sena.gatewayservise.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Component
public class JwtProviderImp implements IJwtProvider {

    @Value("${authentication.jwt.expiration-in-ms}")
    private Long JWT_EXPIRATION_IN_MS;

    private static final String JWT_TOKEN_PREFIX = "Bearer";
    private static final String JWT_HEADER_STRING = "Authentication";

    private final PrivateKey jwtPrivateKey;
    private final PublicKey jwtPublicKey;

    private KeyFactory getKeyFactory() {
        try {
            return KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Unknown key generation algorithm", e);
        }
    }

    public JwtProviderImp(@Value("${authentication.jwt.private-key}") String jwtPrivateKeyStr,
                          @Value("${authentication.jwt.public-key}") String jwtPublicKeyStr) {

        try {
            KeyFactory keyFactory = getKeyFactory();
            Base64.Decoder decoder = Base64.getDecoder();
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(decoder.decode(jwtPrivateKeyStr.getBytes()));
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(decoder.decode(jwtPublicKeyStr.getBytes()));

            jwtPrivateKey = keyFactory.generatePrivate(privateKeySpec);
            jwtPublicKey = keyFactory.generatePublic(publicKeySpec);

        } catch (Exception e) {
            throw new RuntimeException("Invalid key specification", e);
        }
    }



}
