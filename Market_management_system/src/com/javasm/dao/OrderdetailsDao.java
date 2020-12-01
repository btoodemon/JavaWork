package com.javasm.dao;

import com.javasm.entity.OrderDetails;
import com.javasm.util.PageInfo;
import com.javasm.vo.OrderDetailsVO;
import com.javasm.vo.RankingVO;

import java.sql.Connection;
import java.util.List;

public interface OrderdetailsDao {

    /**
     * 添加订单详情
     *
     * @param conn
     * @return
     */
    Boolean insertOrderdetails(Connection conn, OrderDetails orderDetails) throws Exception;

    /**
     * 以商品id查询订单记录
     * @param pageInfo
     * @param orderDetailsVO
     * @return
     */
    List<OrderDetailsVO> findOrderByProductId(PageInfo pageInfo,OrderDetailsVO orderDetailsVO);

    /**
     * 查询总页数
     * @param orderDetailsVO
     * @return
     */
    Integer countTotal(OrderDetailsVO orderDetailsVO);

    /**
     * 排行商品销售
     * @param rankingVO
     * @return
     */
    List<RankingVO> rankingByProduct(RankingVO rankingVO);

    /**
     * 按时间排行销售
     * @param rankingVO
     * @param by
     * @param bm
     * @param ey
     * @param em
     * @return
     */
    List<RankingVO> rankingByTime(RankingVO rankingVO,Integer by,Integer bm,Integer ey,Integer em);

    /**
     * 按类别排行
     * @param rankingVO
     * @return
     */
    List<RankingVO> rankingByType(RankingVO rankingVO);

    /**
     * 按条件排行
     * @param rankingVO
     * @param beTime
     * @param enTime
     * @return
     */
    List<RankingVO> rankingByCondition(RankingVO rankingVO,String beTime,String enTime);
}
