package com.javasm.dao.impl;

import com.javasm.dao.OrderdetailsDao;
import com.javasm.entity.OrderDetails;
import com.javasm.util.JDBCUtils;
import com.javasm.util.PageInfo;
import com.javasm.vo.OrderDetailsVO;
import com.javasm.vo.RankingVO;

import java.sql.Connection;
import java.util.List;

public class OrderdetailsDaoImpl implements OrderdetailsDao {
    @Override
    public Boolean insertOrderdetails(Connection conn, OrderDetails o) throws Exception {
        String sql = "insert into orderdetails values(null,?,?,?,?,?)";
        boolean flag = JDBCUtils.insert(conn, sql, o.getOrderid(),o.getProductid(),o.getPrice(),o.getNum(),o.getMoney()) > 0;
        if (!flag) {
            throw new Exception("失败");
        }
        return flag;
    }

    @Override
    public List<OrderDetailsVO> findOrderByProductId(PageInfo pageInfo, OrderDetailsVO orderDetailsVO) {
        StringBuilder sql = new StringBuilder("SELECT d.*,i.orderdate FROM orderinfo i LEFT JOIN orderdetails d ON i.id=d.orderid where productid=?");
        sql.append(" limit ?,? ");

        return JDBCUtils.getList(sql.toString(),OrderDetailsVO.class,orderDetailsVO.getProductid(),pageInfo.getNowIndex(),pageInfo.getRows());
    }

    @Override
    public Integer countTotal(OrderDetailsVO orderDetailsVO) {
        String sql = "SELECT count(1) FROM orderinfo i LEFT JOIN orderdetails d ON i.id=d.orderid where productid=?";
        return JDBCUtils.getCount(sql,orderDetailsVO.getProductid());
    }

    @Override
    public List<RankingVO> rankingByProduct(RankingVO rankingVO) {
        StringBuilder sql = new StringBuilder("SELECT r.productid,p.pname,p.price,t1.typename,t2.typename typenamepra,r.sumsell");
        sql.append(" FROM (SELECT productid,SUM(num) sumsell FROM orderdetails GROUP BY productid ORDER BY SUM(num) DESC) r");
        sql.append(" LEFT JOIN product p ON p.id=r.productid");
        sql.append(" LEFT JOIN producttype t1 ON p.typeid=t1.id");
        sql.append(" INNER JOIN producttype t2 ON t1.Parentid=t2.id");
        sql.append(" limit 0,10 ");
        return JDBCUtils.getList(sql.toString(), RankingVO.class);
    }

    @Override
    public List<RankingVO> rankingByTime(RankingVO rankingVO,Integer by,Integer bm,Integer ey,Integer em) {
        StringBuilder sql = new StringBuilder("SELECT d.*,p.pname");
        sql.append(" FROM (SELECT d.productid,i.orderdate,SUM(num) sumsell FROM orderdetails d LEFT JOIN orderinfo i ON i.id=d.orderid WHERE orderdate");
        sql.append(" BETWEEN '"+by+"-"+bm+"-1' AND '"+ey+"-"+em+"-1'");
        sql.append(" GROUP BY productid ORDER BY SUM(num) DESC) d LEFT JOIN product p ON d.productid=p.id");
        sql.append(" limit 0,10 ");
        return JDBCUtils.getList(sql.toString(), RankingVO.class);
    }

    @Override
    public List<RankingVO> rankingByType(RankingVO rankingVO) {
        StringBuilder sql = new StringBuilder("SELECT SUM(d.num) sumsell,t.typename,d.productid,p.pname");
        sql.append(" FROM orderdetails d LEFT JOIN product p ON d.productid=p.id");
        sql.append(" LEFT JOIN producttype t ON p.typeid=t.id");
        sql.append(" WHERE t.typename=?");
        sql.append(" GROUP BY productid ORDER BY SUM(d.num) DESC");
        sql.append(" limit 0,10 ");
        return JDBCUtils.getList(sql.toString(), RankingVO.class,rankingVO.getTypename());
    }

    @Override
    public List<RankingVO> rankingByCondition(RankingVO rankingVO,String beTime,String enTime) {
        StringBuilder sql = new StringBuilder("SELECT SUM(d.num) sumsell,d.productid,p.pname,i.orderdate,t1.typename,t2.typename typenamepra,v.cardnumber FROM orderdetails d LEFT JOIN orderinfo i ON d.orderid=i.id LEFT JOIN product p ON d.productid=p.id LEFT JOIN producttype t1 ON p.typeid=t1.id INNER JOIN producttype t2 ON t1.Parentid=t2.id LEFT JOIN vip v ON i.vipid=v.id");
        sql.append(" WHERE 1=1");
        if (rankingVO.getTypename()!= null && !"".equals(rankingVO.getTypename())) {
            sql.append(" AND t1.typename='"+rankingVO.getTypename()+"'");
        }
        sql.append(" AND i.orderdate BETWEEN '"+beTime+"-1' AND '"+enTime+"-31'");
        if (rankingVO.getCardnumber()!=null && !"".equals(rankingVO.getCardnumber())){
            sql.append(" AND v.cardnumber='"+rankingVO.getCardnumber()+"'");
        }
        sql.append(" GROUP BY d.productid ORDER BY SUM(d.num) DESC");
        sql.append(" limit 0,10 ");


        //sql.append();

        return JDBCUtils.getList(sql.toString(), RankingVO.class);
    }
}
