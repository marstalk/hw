package com.classm.bean.resp;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResp {
    private String token;

    private int userId;
    private String firstName;
    private String lastName;

    private String email;
    private String birth;

}
