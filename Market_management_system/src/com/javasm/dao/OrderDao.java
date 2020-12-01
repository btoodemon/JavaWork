package com.javasm.dao;

import com.javasm.entity.OrderInfo;
import com.javasm.util.PageInfo;
import com.javasm.vo.OrderInfoVO;

import java.sql.Connection;
import java.util.List;

public interface OrderDao {

    /**
     * 添加订单
     *
     * @param conn      连接对象
     * @param orderInfo order对象
     * @return
     */
    Integer insertOrder(Connection conn, OrderInfo orderInfo);

    /**
     * 通过会员卡号查询订单记录
     * @param pageInfo
     * @param orderInfoVO
     * @return
     */
    List<OrderInfoVO> findOrderByVipCard(PageInfo pageInfo, OrderInfoVO orderInfoVO);

    /**
     * 总页数
     * @param orderInfoVO
     * @return
     */
    Integer countTotal(OrderInfoVO orderInfoVO);
}
