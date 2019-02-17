package com.classm.service;

import com.classm.bean.*;
import com.classm.dao.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsUrlMapper goodsUrlMapper;
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;
    @Autowired
    private LikeMapper likeMapper;
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public Goods saveGoods(Goods goods) {

        goods.setGoodsId(UUID.randomUUID().toString());
        goodsMapper.saveGoods(goods);

        if (!CollectionUtils.isEmpty(goods.getPicUrls())) {
            List<GoodsUrl> goodsUrls = new ArrayList<>();
            for (String url : goods.getPicUrls()) {
                GoodsUrl goodsUrl = new GoodsUrl(goods.getGoodsId(), url);
                goodsUrls.add(goodsUrl);
            }
            goodsUrlMapper.saveUrls(goodsUrls);
        }

        return goods;
    }

    public List<GoodsType> queryAllTypes() {
        return goodsTypeMapper.queryAll();
    }

    public List<Goods> query(String goodsName, int type) {
        List<Goods> goodsList = goodsMapper.query(goodsName, type);
        fillUrl(goodsList);
        return goodsList;
    }

    private void fillUrl(List<Goods> goodsList) {
        if (null != goodsList && goodsList.size() != 0) {
            List<String> urlList = goodsList.stream().map(Goods::getGoodsId).collect(Collectors.toList());
            List<GoodsUrl> goodsUrls = goodsUrlMapper.queryByGoodsIds(urlList);

            for (int i = 0; i < goodsList.size(); i++) {
                Goods g = goodsList.get(i);
                for (int j = 0; j < goodsUrls.size(); j++) {
                    GoodsUrl u = goodsUrls.get(j);
                    if (g.getGoodsId().equalsIgnoreCase(u.getGoodsId())) {
                        g.addPicUrl(u.getPicUrl());
                    }
                }
            }

        }
    }

    public Goods queryById(String goodsId) {
        Goods goods = goodsMapper.queryById(goodsId);
        if (null != goods) {
            List<Goods> goodsList = new ArrayList<>();
            goodsList.add(goods);
            fillUrl(goodsList);
            return goodsList.get(0);
        }

        return goods;
    }

    public List<UserBasic> findLikes(String goodsId) {
        List<Integer> userByGoodsId = likeMapper.findUserByGoodsId(goodsId);

        if (null == userByGoodsId || userByGoodsId.size() == 0) {
            return null;
        }

        List<UserBasic> userBasics = userMapper.findUsersByIds(userByGoodsId);
        return userBasics;
    }
}
