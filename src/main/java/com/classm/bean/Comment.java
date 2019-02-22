package com.classm.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @ApiModelProperty(hidden = true)
    private int id;

    @ApiModelProperty(hidden = true)
    private int userId;

    @ApiModelProperty(hidden = true)
    private String userName;

    @ApiModelProperty(hidden = true)
    private String goodsId;

    private String comment;

    @ApiModelProperty(hidden = true)
    private Date date;
}
