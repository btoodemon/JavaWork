package com.javasm.dao;

import com.javasm.entity.Userinfo;

public interface UserinfoDao {

    Userinfo login(String userName, String pwd);

}
