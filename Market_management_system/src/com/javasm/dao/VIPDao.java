package com.javasm.dao;

import com.javasm.entity.UserManage;
import com.javasm.util.PageInfo;

import java.sql.Connection;
import java.util.List;

public interface VIPDao {

    /**
     * 修改会员的余额
     *
     * @param conn  连接对象
     * @param vipid 卡号
     * @param money 付款金额
     * @return
     */
    Boolean updateVipMoney(Connection conn, Integer vipid, Double money);

    /**
     * 修改会员积分
     * @param conn
     * @param vipid
     * @param jifen
     * @return
     */
    Boolean updateVipJifen(Connection conn, Integer vipid, Integer jifen);

    /**
     * 查询用户
     * @param pageInfo
     * @param userManage
     * @return
     */
    List<UserManage> findUserByPage(PageInfo pageInfo, UserManage userManage);

    /**
     * 总页数
     * @param userManage
     * @return
     */
    Integer countTotal(UserManage userManage);

    /**
     * 查询cardnumber是否存在
     * @param cardnumber
     * @return
     */
    UserManage findUserByCardnumber(String cardnumber);
    /**
     * 添加用户
     * @param userManage
     * @return
     */
    Boolean insertUser(UserManage userManage);

    /**
     * 修改用户
     * @param userManage
     * @return
     */
    Boolean updateUser(String cardnumber,UserManage userManage);

    /**
     * 删除用户
     * @param cardnumber
     * @return
     */
    Boolean deleteUser(String cardnumber);

}
