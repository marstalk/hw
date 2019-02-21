package com.classm.service;


import com.classm.bean.User;
import com.classm.dao.mapper.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    @Autowired
    private LikeMapper likeMapper;


    public void like(int userId, String goodsId) {
        likeMapper.saveLike(userId, goodsId);
    }

    public void dislike(int userId, String goodsId) {
        likeMapper.deleteLike(userId, goodsId);
    }
}
