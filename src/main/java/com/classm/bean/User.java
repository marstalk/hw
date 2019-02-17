package com.classm.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public static final String TYPE_PHONE = "phone";
    public static final String TYPE_EMAIL = "email";

    @ApiModelProperty(hidden = true)
    private int id;
    @ApiModelProperty()
    private String type;
    private String phone;
    private String email;
    private String gender;
    private String firstName;
    private String lastName;
    private String birth;
    private String notify;
    private String pwd;


}
