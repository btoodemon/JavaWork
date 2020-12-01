package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Userinfo {

    private String username;
    private String pwd;
    private Integer roleid;// 1: 管理员   2：收银员

}
