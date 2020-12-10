package com.javasm.entity;

public class Userinfo {

    private Integer userId;
    private String userName;
    private String pwd;
    private Integer roleId;
    private Integer sex;
    private String aiaho;
    private String iphone;
    private String birthday;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAiaho() {
        return aiaho;
    }

    public void setAiaho(String aiaho) {
        this.aiaho = aiaho;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Userinfo() {
    }

    public Userinfo(String userName, String pwd, Integer roleId, Integer sex, String aiaho, String iphone, String birthday) {

        this.userName = userName;
        this.pwd = pwd;
        this.roleId = roleId;
        this.sex = sex;
        this.aiaho = aiaho;
        this.iphone = iphone;
        this.birthday = birthday;
    }

    public Userinfo(Integer userId, String userName, String pwd, Integer roleId, Integer sex, String aiaho, String iphone, String birthday) {

        this.userId = userId;
        this.userName = userName;
        this.pwd = pwd;
        this.roleId = roleId;
        this.sex = sex;
        this.aiaho = aiaho;
        this.iphone = iphone;
        this.birthday = birthday;
    }
}
