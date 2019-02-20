package com.classm.controller;


import com.classm.bean.*;
import com.classm.bean.resp.QueryGoodsByIdResp;
import com.classm.service.FileService;
import com.classm.service.GoodsService;
import com.classm.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping()
public class GoodsController extends BaseController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private FileService fileService;
    @Autowired
    private UserService userService;

    @ApiOperation("post goods")
    @PostMapping("/security/goods")
    public JsonEntity<Goods> postGoods(HttpServletRequest request, @RequestBody Goods goods) {
        User user = currentUser(request);
        goods.setOwner(user.getId());
        Goods resulGoods = goodsService.saveGoods(goods);
        return ResponseHelper.of(resulGoods);
    }

    @ApiOperation("upload goods pic")
    @PostMapping("/security/pic")
    public JsonEntity<String> postPic(HttpServletRequest request, @RequestBody MultipartFile picFile) {
        String picUrl = fileService.saveFile(picFile, request);
        return ResponseHelper.of(picUrl);
    }

    @ApiOperation("query goods")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型ID，从GoodsType中获取。"),
            @ApiImplicitParam(name = "goodsName", value = "商品名称，模糊搜索")
    })
    @GetMapping("/goods")
    public JsonEntity<List<Goods>> queryGoods(@RequestParam int type, @RequestParam(required = false) String goodsName) {
        List<Goods> goodsList = goodsService.query(goodsName, type);
        return ResponseHelper.of(goodsList);
    }

    @ApiOperation("query all goods type")
    @GetMapping("/goods/type")
    public JsonEntity<List<GoodsType>> queryGoodsType() {
        List<GoodsType> goodsTypes = goodsService.queryAllTypes();
        return ResponseHelper.of(goodsTypes);
    }

    @ApiOperation("query goods by Id")
    @GetMapping("/goods/{goodsId}")
    public JsonEntity<QueryGoodsByIdResp> queryGoodsById(@PathVariable String goodsId) {
        Goods goods = goodsService.queryById(goodsId);
        if (null == goods) {
            return ResponseHelper.error(-1, "goods do not exist");
        }

        User user = userService.findUserById(goods.getOwner());
        List<UserBasic> likeUsers = goodsService.findLikes(goods.getGoodsId());


        QueryGoodsByIdResp resp = new QueryGoodsByIdResp();
        resp.setGoods(goods);
        resp.setOwner(new UserBasic(user));
        resp.setLikes(likeUsers);

        return ResponseHelper.of(resp);
    }


}
