package com.classm.bean;


import lombok.Data;

@Data
public class JsonEntity<T> {
    private T data;
    private int code = 0;
    private String msg = "success";
}
