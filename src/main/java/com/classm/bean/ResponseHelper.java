package com.classm.bean;


import com.alibaba.fastjson.JSONObject;

public class ResponseHelper {

    public static JsonEntity of(Object obj) {
        JsonEntity jsonEntity = new JsonEntity();
        jsonEntity.setData(obj);
        return jsonEntity;
    }

    public static JsonEntity error(int code, String msg) {
        JsonEntity jsonEntity = new JsonEntity();
        jsonEntity.setCode(code);
        jsonEntity.setMsg(msg);
        return jsonEntity;
    }
}
