package com.classm.service;

import com.classm.bean.Comment;
import com.classm.dao.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public void comment(Comment comment) {
        commentMapper.save(comment);
    }

    public List<Comment> queryByGoodsId(String goodsId) {
        List<Comment> comments = commentMapper.query(goodsId);
        return comments;
    }
}
