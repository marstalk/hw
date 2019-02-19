package com.classm.bean.req;

import com.classm.bean.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class SignUpReq {
    @ApiModelProperty(required = true, allowableValues = "{phone, email}")
    private String type;

    @ApiModelProperty(required = true)
    private String loginName;

    @ApiModelProperty(required = true)
    private String firstName;

    @ApiModelProperty(required = true)
    private String lastName;

    @ApiModelProperty(required = true, value = "md5 value")
    private String pwd;

    @ApiModelProperty(required = true, value = "string birth like yyyy-MM-dd")
    private String birth;

    @ApiModelProperty(allowableValues = "{N, Y}")
    private String notify;

    @ApiModelProperty(required = true)
    private String verifyCode;
}


