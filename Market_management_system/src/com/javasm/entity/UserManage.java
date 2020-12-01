package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserManage {

    private Integer id;
    private String cardnumber;
    private String vipname;
    private String iphone;
    private Integer jifen;
    private Double money;
    private String createTime;
    private String updateTime;

    public UserManage(String cardnumber, String vipname, String iphone, Integer jifen, Double money, String createTime, String updateTime) {
        this.cardnumber = cardnumber;
        this.vipname = vipname;
        this.iphone = iphone;
        this.jifen = jifen;
        this.money = money;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public UserManage(String vipname, String iphone, Integer jifen, Double money) {
        this.vipname = vipname;
        this.iphone = iphone;
        this.jifen = jifen;
        this.money = money;
    }

    @Override
    public String toString() {
        return "UserManage{" +
                "id=" + id +
                ", cardnumber='" + cardnumber + '\'' +
                ", vipname='" + vipname + '\'' +
                ", iphone='" + iphone + '\'' +
                ", jifen=" + jifen +
                ", money=" + money +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
