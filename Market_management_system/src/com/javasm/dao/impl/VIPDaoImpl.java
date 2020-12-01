package com.javasm.dao.impl;

import com.javasm.dao.VIPDao;
import com.javasm.entity.UserManage;
import com.javasm.util.JDBCUtils;
import com.javasm.util.PageInfo;

import java.sql.Connection;
import java.util.List;

public class VIPDaoImpl implements VIPDao {
    @Override
    public Boolean updateVipMoney(Connection conn, Integer vipid, Double money) {
        String sql = "UPDATE vip SET money=? where id=?";
        return JDBCUtils.update(conn, sql, money, vipid) > 0;
    }

    @Override
    public Boolean updateVipJifen(Connection conn, Integer vipid, Integer jifen) {
        String sql = "UPDATE vip SET jifen=? where id=?";
        return JDBCUtils.update(conn, sql, jifen, vipid) > 0;
    }

    @Override
    public List<UserManage> findUserByPage(PageInfo pageInfo, UserManage userManage) {
        StringBuilder sql = new StringBuilder("select * from vip where 1=1");
        if (userManage != null) {
            if (userManage.getCardnumber() != null && !"".equals(userManage.getCardnumber())) {
                sql.append(" and cardnumber like '%" + userManage.getCardnumber() + "%'");
            }
            if (userManage.getVipname() != null && !"".equals(userManage.getVipname())) {
                sql.append(" and vipname like '%" + userManage.getVipname() + "%'");
            }
            if (userManage.getIphone() != null && !"".equals(userManage.getIphone())) {
                sql.append(" and iphone like '%" + userManage.getIphone() + "%'");
            }
        }
        sql.append(" limit ?,? ");
        return JDBCUtils.getList(sql.toString(), UserManage.class, pageInfo.getNowIndex(), pageInfo.getRows());
    }

    @Override
    public Integer countTotal(UserManage userManage) {
        StringBuilder sql = new StringBuilder("select count(1) from vip where 1=1 ");
        if (userManage != null) {
            if (userManage.getCardnumber() != null && !"".equals(userManage.getCardnumber())) {
                sql.append(" and cardnumber like '%" + userManage.getCardnumber() + "%'");
            }
            if (userManage.getVipname() != null && !"".equals(userManage.getVipname())) {
                sql.append(" and vipname like '%" + userManage.getVipname() + "%'");
            }
            if (userManage.getIphone() != null && !"".equals(userManage.getIphone())) {
                sql.append(" and iphone like '%" + userManage.getIphone() + "%'");
            }
        }
        return JDBCUtils.getCount(sql.toString());
    }

    @Override
    public UserManage findUserByCardnumber(String cardnumber) {
        String sql = "select * from vip where cardnumber = ?";
        return JDBCUtils.get(sql, UserManage.class, cardnumber);
    }

    @Override
    public Boolean insertUser(UserManage u) {
        String sql = "insert into vip values(null,?,?,?,?,?,null,null)";
        int result = JDBCUtils.insert(sql, u.getCardnumber(),u.getVipname(),u.getIphone(),u.getJifen(),u.getMoney());
        return result > 0;
    }

    @Override
    public Boolean updateUser(String cardnumber,UserManage userManage) {
        StringBuilder sql = new StringBuilder("UPDATE vip SET id=id");

        if (userManage.getCardnumber() != null && !"".equals(userManage.getCardnumber())) {
            sql.append(",cardnumber='" + userManage.getCardnumber() + "'");
        }
        if (userManage.getVipname() != null && !"".equals(userManage.getVipname())) {
            sql.append(",vipname='" + userManage.getVipname()+ "'");
        }
        if (userManage.getIphone() != null && !"".equals(userManage.getIphone())) {
            sql.append(",iphone='" + userManage.getIphone()+ "'");
        }
        if (userManage.getJifen() != null && !"".equals(userManage.getJifen())) {
            sql.append(",jifen=" + userManage.getJifen());
        }
        if (userManage.getMoney() != null && !"".equals(userManage.getMoney())) {
            sql.append(",money=" + userManage.getMoney());
        }

        sql.append(" where cardnumber=?");

        int result = JDBCUtils.update(sql.toString(), cardnumber);
        return result > 0;
    }

    @Override
    public Boolean deleteUser(String cardnumber) {
        String sql = "DELETE FROM vip where cardnumber= ?";
        int result = JDBCUtils.delete(sql, cardnumber);
        return result > 0;
    }
}
