package com.classm.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.classm.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;


@Slf4j
public class BaseController {

    protected int currentUserId(HttpServletRequest request) {
        String token = request.getHeader("hw-token");
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asInt();
        } catch (JWTDecodeException e){
            log.error(e.getMessage(), e);
            return -1;
        }
    }
}
