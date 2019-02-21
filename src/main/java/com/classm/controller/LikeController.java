package com.classm.controller;


import com.classm.bean.JsonEntity;
import com.classm.bean.ResponseHelper;
import com.classm.bean.User;
import com.classm.service.LikeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LikeController extends BaseController{

    @Autowired
    private LikeService likeService;


    @ApiOperation("like goods")
    @PostMapping("/security/like/{goodsId}")
    public JsonEntity<String> like(HttpServletRequest request, @PathVariable String goodsId){
        int userId = currentUserId(request);
        likeService.like(userId, goodsId);
        return ResponseHelper.of("like!");
    }

    @ApiOperation("dislike goods")
    @DeleteMapping("/security/like/{goodsId}")
    public JsonEntity<String> dislike(HttpServletRequest request, @PathVariable String goodsId){
        int userId = currentUserId(request);
        likeService.dislike(userId, goodsId);
        return ResponseHelper.of("dislike!");
    }

}
