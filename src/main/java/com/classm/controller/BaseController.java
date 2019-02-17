package com.classm.controller;


import com.classm.bean.User;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    protected User currentUser(HttpServletRequest request) {
        User user = (User)request.getSession(true).getAttribute("user");
        return user;
    }

}
