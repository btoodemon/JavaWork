package com.javasm.dao.impl;

import com.javasm.dao.OrderDao;
import com.javasm.entity.OrderInfo;
import com.javasm.util.JDBCUtils;
import com.javasm.util.PageInfo;
import com.javasm.vo.OrderInfoVO;

import java.sql.Connection;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public Integer insertOrder(Connection conn, OrderInfo orderInfo) {
        String sql = "insert into orderinfo values(null,?,null,?,?)";
        return JDBCUtils.insert(conn, sql, orderInfo.getVipid(),orderInfo.getPaytype(),orderInfo.getMoney());
    }

    @Override
    public List<OrderInfoVO> findOrderByVipCard(PageInfo pageInfo, OrderInfoVO orderInfoVO) {
        StringBuilder sql = new StringBuilder("SELECT o.*,v.cardnumber,v.vipname FROM orderinfo o LEFT JOIN vip v ON o.vipid=v.id");
        sql.append(" where cardnumber=?");
        sql.append(" limit ?,? ");
        return JDBCUtils.getList(sql.toString(), OrderInfoVO.class, orderInfoVO.getCardnumber(),pageInfo.getNowIndex(),pageInfo.getRows());
    }

    @Override
    public Integer countTotal(OrderInfoVO orderInfoVO) {
        String sql = "SELECT count(1) FROM orderinfo o LEFT JOIN vip v ON o.vipid=v.id where cardnumber=?";
        return JDBCUtils.getCount(sql,orderInfoVO.getCardnumber());
    }
}
