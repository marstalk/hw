package com.classm.bean.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginReq {

    @ApiModelProperty(required = true, value = "phone or email", allowableValues = "{email, phone}")
    private String type;
    @ApiModelProperty(required = true)
    private String loginName;
    @ApiModelProperty(required = true, value = "md5 password")
    private String pwd;

}
