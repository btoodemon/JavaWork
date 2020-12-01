package com.javasm.service;

import com.javasm.dao.OrderDao;
import com.javasm.dao.OrderdetailsDao;
import com.javasm.dao.impl.OrderDaoImpl;
import com.javasm.dao.impl.OrderdetailsDaoImpl;
import com.javasm.util.PageInfo;
import com.javasm.vo.OrderDetailsVO;
import com.javasm.vo.OrderInfoVO;

import java.util.List;
import java.util.Scanner;

public class OrderService {
    Scanner out = new Scanner(System.in);
    OrderdetailsDao orderdetailsDao = new OrderdetailsDaoImpl();
    OrderDao orderDao = new OrderDaoImpl();
    public void startOrderMenu() {

        while (true) {
            System.out.println("位置：订单管理 --> 查询订单");
            System.out.println("1.按商品id查询  2.查询用户购买记录  3.返回");
            String chose = out.next();
            switch (chose) {
                case "1":
                    findOrderByProductId();
                    break;
                case "2":
                    findOrderByUser();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("输入不合法,重新输入");
            }
        }
    }

    /**
     * 按用户查询
     */
    private void findOrderByUser() {
        System.out.println("请输入用户卡号: ");
        String cardnumber = out.next();
        OrderInfoVO orderInfoVO = new OrderInfoVO();
        orderInfoVO.setCardnumber(cardnumber);

        //统计总条数
        Integer total = orderDao.countTotal(orderInfoVO);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotal(total);
        List<OrderInfoVO> list = orderDao.findOrderByVipCard(pageInfo, orderInfoVO);
        printOrder(list);

        Boolean flagNextPage = true;
        while (flagNextPage){
            System.out.println("总页数：" + pageInfo.getTotalPage() + " \t 总条数：" + pageInfo.getTotal() + " \t 当前页：" + pageInfo.getPage());
            System.out.println("1.首页 \t 2.上一页 \t 3.下一页 \t 4.尾页 \t 5.返回上一层(查看商品)  ");
            String chosePage = out.next();
            switch (chosePage) {
                case "1":
                    // 给page赋值（当前页）
                    pageInfo.setPage(1);
                    list = orderDao.findOrderByVipCard(pageInfo, orderInfoVO);
                    printOrder(list);
                    break;
                case "2":
                    if (pageInfo.hashUpPage()) {
                        list = orderDao.findOrderByVipCard(pageInfo, orderInfoVO);
                        printOrder(list);
                    }
                    break;
                case "3":
                    if (pageInfo.hashNextPage()) {
                        list = orderDao.findOrderByVipCard(pageInfo, orderInfoVO);
                        printOrder(list);
                    }
                    break;
                case "4":
                    // 给page赋值（当前页）
                    pageInfo.setPage(pageInfo.getTotalPage());
                    list = orderDao.findOrderByVipCard(pageInfo, orderInfoVO);
                    printOrder(list);
                    break;
                case "5":
                    flagNextPage = false;
                    break;
                default:
                    System.out.println("输入有误，请重新输入!");
                    break;
            }
        }
    }

    /**
     * 按用户查询打印方法
     * @param list
     */
    private void printOrder(List<OrderInfoVO> list) {
        System.out.println("卡号\t\t会员\t\t订单号\t金额\t\t订单时间");
        list.forEach(o->{
            System.out.println(o.getCardnumber()+"\t"+o.getVipname()+"\t\t"+o.getId()+"\t\t"+o.getMoney()+"\t"+o.getOrderdate());
        });
    }

    /**
     * 按商品id查询
     */
    private void findOrderByProductId() {
        System.out.println("请输入商品ID: ");
        Integer productid = out.nextInt();
        OrderDetailsVO orderDetailsVO = new OrderDetailsVO();
        orderDetailsVO.setProductid(productid);

        //统计总条数
        Integer total = orderdetailsDao.countTotal(orderDetailsVO);
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotal(total);
        List<OrderDetailsVO> list = orderdetailsDao.findOrderByProductId(pageInfo, orderDetailsVO);
        printOrderDetails(list);

        Boolean flagNextPage = true;
        while (flagNextPage){
            System.out.println("总页数：" + pageInfo.getTotalPage() + " \t 总条数：" + pageInfo.getTotal() + " \t 当前页：" + pageInfo.getPage());
            System.out.println("1.首页 \t 2.上一页 \t 3.下一页 \t 4.尾页 \t 5.返回上一层(查看商品)  ");
            String chosePage = out.next();
            switch (chosePage) {
                case "1":
                    // 给page赋值（当前页）
                    pageInfo.setPage(1);
                    list = orderdetailsDao.findOrderByProductId(pageInfo, orderDetailsVO);
                    printOrderDetails(list);
                    break;
                case "2":
                    if (pageInfo.hashUpPage()) {
                        list = orderdetailsDao.findOrderByProductId(pageInfo, orderDetailsVO);
                        printOrderDetails(list);
                    }
                    break;
                case "3":
                    if (pageInfo.hashNextPage()) {
                        list = orderdetailsDao.findOrderByProductId(pageInfo, orderDetailsVO);
                        printOrderDetails(list);
                    }
                    break;
                case "4":
                    // 给page赋值（当前页）
                    pageInfo.setPage(pageInfo.getTotalPage());
                    list = orderdetailsDao.findOrderByProductId(pageInfo, orderDetailsVO);
                    printOrderDetails(list);
                    break;
                case "5":
                    flagNextPage = false;
                    break;
                default:
                    System.out.println("输入有误，请重新输入!");
                    break;
            }
        }

    }

    /**
     * 按商品id查询打印方法
     * @param list
     */
    private void printOrderDetails(List<OrderDetailsVO> list) {
        System.out.println("订单ID\t单价\t\t数量\t\t价格\t\t订单时间");
        list.forEach(o->{
            System.out.println(o.getId()+"\t\t"+o.getPrice()+"\t\t"+o.getNum()+"\t\t"+o.getMoney()+"\t\t"+o.getOrderdate());
        });
    }
}
