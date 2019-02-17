package com.classm.service;


import com.classm.bean.User;
import com.classm.dao.mapper.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    @Autowired
    private LikeMapper likeMapper;


    public void like(User user, String goodsId) {
        likeMapper.saveLike(user.getId(), goodsId);
    }

    public void dislike(User user, String goodsId) {
        likeMapper.deleteLike(user.getId(), goodsId);
    }
}
