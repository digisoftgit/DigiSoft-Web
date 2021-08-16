package com.digisoft.com.digisoftitweb.security.annotations.validator;

import com.digisoft.com.digisoftitweb.security.exception.NotAuthorizedUserAccessException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application-dev.properties")
public class JwtValidator {


    @Value("${tokenSecret}")
    private String jwtSecret;


    private final JwtUtils jwtUtils;

    @Autowired
    public JwtValidator(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @SneakyThrows
    public String validate(String token) {
        try {
            if (jwtUtils.validateJwtToken(token.substring(7))) {
                Claims body = Jwts.parser()
                        .setSigningKey(jwtSecret)
                        .parseClaimsJws(token.substring(7))
                        .getBody();
                return body.getSubject();
            } else {
                throw new NotAuthorizedUserAccessException();
            }
        } catch (Exception e) {
            throw new NotAuthorizedUserAccessException();
        }
    }
}
