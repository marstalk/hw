package com.classm.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.classm.bean.ResponseHelper;
import com.classm.bean.User;
import com.classm.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Value("${auth.switch}")
    private String on;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (needAuth(request)) {
            if (request.getMethod().equals("OPTIONS")){
                response.setStatus(HttpServletResponse.SC_OK);
                return true;
            }
            response.setCharacterEncoding("utf-8");
            String token = request.getHeader("hw-token");
            if (token != null){
                boolean result = TokenUtil.verify(token);
                if(result){
                    return true;
                }
            }
            printResponse(response);
            return false;
        }

        return true;
    }

    private boolean needAuth(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/hw/security") && "1".equals(on);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (needAuth(request)) {
            String token = request.getHeader("hw-token");
            try {
                DecodedJWT jwt = JWT.decode(token);
                String loginName = jwt.getClaim("loginName").asString();
                String userId = jwt.getClaim("userId").asString();
                String newToken = TokenUtil.sign(loginName, userId);
                response.setHeader("hw-token", token);
            } catch (JWTDecodeException e){
                log.error(e.getMessage(), e);
            }
        }
    }

    private void printResponse(HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json;charset=UTF-8");

        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(JSONObject.toJSONString(ResponseHelper.error(-1, "token invalid or missing, please login!")).getBytes());
            outputStream.flush();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (null != outputStream) {
                outputStream.close();
            }
        }
    }
}
