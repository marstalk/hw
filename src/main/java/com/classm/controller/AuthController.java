package com.classm.controller;

import com.classm.bean.JsonEntity;
import com.classm.bean.ResponseHelper;
import com.classm.bean.User;
import com.classm.bean.req.LoginReq;
import com.classm.bean.req.SignUpReq;
import com.classm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public JsonEntity<String> login(@RequestBody LoginReq loginReq, HttpServletRequest request) {

        User user = null;
        if (loginReq.getType().equalsIgnoreCase(User.TYPE_EMAIL)) {
            user = userService.findUserByEmail(loginReq.getLoginName());
        } else if (loginReq.getType().equalsIgnoreCase(User.TYPE_PHONE)) {
            user = userService.findUserByPhone(loginReq.getLoginName());
        }
        if (null == user || !user.getPwd().equals(loginReq.getPwd())) {
            return ResponseHelper.error(-1, "user do not exist or password is wrong, please try again.");
        }

        //login successfully
        request.getSession().setAttribute("user", user);

        return ResponseHelper.of("login!");
    }


    @DeleteMapping("/logout")
    public JsonEntity<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return ResponseHelper.of("logout");
    }

    @PostMapping("/sign-up")
    public JsonEntity<String> signUp(@RequestBody SignUpReq signUpReq) {
        //TODO

        return ResponseHelper.of("sign-up!");
    }

}
