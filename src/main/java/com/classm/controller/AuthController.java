package com.classm.controller;

import com.classm.bean.JsonEntity;
import com.classm.bean.ResponseHelper;
import com.classm.bean.User;
import com.classm.bean.req.LoginReq;
import com.classm.bean.req.SignUpReq;
import com.classm.bean.resp.LoginResp;
import com.classm.service.UserService;
import com.classm.service.VerifyCodeService;
import com.classm.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private VerifyCodeService verifyCodeService;

    @PostMapping("/login")
    public JsonEntity<LoginResp> login(@RequestBody LoginReq loginReq, HttpServletResponse response) {

        User user = null;
        if (loginReq.getType().equalsIgnoreCase(User.TYPE_EMAIL)) {
            user = userService.findUserByEmail(loginReq.getLoginName());
        } else if (loginReq.getType().equalsIgnoreCase(User.TYPE_PHONE)) {
            user = userService.findUserByPhone(loginReq.getLoginName());
        }
        if (null == user || !user.getPwd().equals(loginReq.getPwd())) {
            return ResponseHelper.error(-1, "user do not exist or password is wrong, please try again.");
        }

        String token = TokenUtil.sign(loginReq.getLoginName(), String.valueOf(user.getId()));
        LoginResp resp = new LoginResp();
        resp.setFirstName(user.getFirstName());
        resp.setLastName(user.getLastName());
        resp.setUserId(user.getId());
        resp.setBirth(user.getBirth());
        resp.setEmail(user.getEmail());
        resp.setToken(token);

        response.setHeader("hw-token", token);

        return ResponseHelper.of(resp);
    }


    @PostMapping("/sign-up")
    public JsonEntity<String> signUp(HttpServletRequest request, @RequestBody SignUpReq signUpReq) {
        String verifyCode = (String) request.getSession().getAttribute("verifyCode");
        if (null == verifyCode || !verifyCode.equalsIgnoreCase(signUpReq.getVerifyCode())) {
            return ResponseHelper.error(-1, "verify code error");
        }

        User user = new User();
        user.setType(signUpReq.getType());
        String loginName = signUpReq.getLoginName();
        if (signUpReq.getType().equals("email")) {
            user.setEmail(loginName);
        } else if (signUpReq.getType().equalsIgnoreCase("phone")) {
            user.setPhone(loginName);
        } else {
            return ResponseHelper.error(-2, "type should email or phone only");
        }

        user.setFirstName(signUpReq.getFirstName());
        user.setLastName(signUpReq.getLastName());
        user.setPwd(signUpReq.getPwd());
        user.setBirth(signUpReq.getBirth());
        user.setNotify(null == signUpReq.getNotify() ? "N" : signUpReq.getNotify());

        userService.save(user);


        return ResponseHelper.of("sign-up!");
    }

    @GetMapping("/verify-code")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        verifyCodeService.generateCode(request, response);
    }

}
