package com.javasm.dao.impl;

import com.javasm.dao.UserinfoDao;
import com.javasm.entity.Userinfo;
import com.javasm.util.JDBCUtils;

public class UserinfoDaoImpl implements UserinfoDao {
    @Override
    public Userinfo login(String userName, String pwd) {
        String sql = "select * from userinfo where username=? and pwd = ?";
        Userinfo userinfo = JDBCUtils.get(sql, Userinfo.class, userName, pwd);
        return userinfo;
    }
}
