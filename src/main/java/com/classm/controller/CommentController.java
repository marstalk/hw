package com.classm.controller;

import com.classm.bean.Comment;
import com.classm.bean.JsonEntity;
import com.classm.bean.ResponseHelper;
import com.classm.bean.User;
import com.classm.service.CommentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CommentController extends BaseController{

    @Autowired
    private CommentService commentService;

    @ApiOperation("post a comment")
    @PostMapping("/security/comment/{goodsId}")
    public JsonEntity<String> postComment(HttpServletRequest request, @PathVariable String goodsId, @RequestBody String commentStr) {
        User user = currentUser(request);

        Comment comment = new Comment(user.getId(), user.getFirstName(), goodsId, commentStr);
        commentService.comment(comment);
        return ResponseHelper.of("comment!");
    }


    @ApiOperation("query comment of a goods")
    @GetMapping("/comment/{goodsId}")
    public JsonEntity<List<Comment>> queryComments(@PathVariable String goodsId) {
        List<Comment> comments = commentService.queryByGoodsId(goodsId);
        return ResponseHelper.of(comments);
    }



}