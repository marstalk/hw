package com.classm.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.classm.bean.ResponseHelper;
import com.classm.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Value("auth.switch")
    private String on;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getRequestURI().startsWith("/hw/security") && "1".equals(on)) {
            User login = (User) request.getSession().getAttribute("user");

            if (null == login) {
                printResponse(response);
                return false;
            }
        }

        return true;
    }

    private void printResponse(HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json;charset=UTF-8");

        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(JSONObject.toJSONString(ResponseHelper.error(-1, "please login!")).getBytes());
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
