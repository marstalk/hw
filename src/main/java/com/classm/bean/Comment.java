package com.classm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int id;

    private int userId;

    private String userName;

    private String goodsId;

    private String comment;

    private Date date;

    public Comment(int userId, String firstName, String goodsId, String commentStr) {
        this.userId = userId;
        this.userName = firstName;
        this.goodsId = goodsId;
        this.comment = commentStr;
        this.date = new Date();
    }
}
