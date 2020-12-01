package com.javasm.service;

import com.javasm.dao.OrderDao;
import com.javasm.dao.OrderdetailsDao;
import com.javasm.dao.ProductDao;
import com.javasm.dao.VIPDao;
import com.javasm.dao.impl.OrderDaoImpl;
import com.javasm.dao.impl.OrderdetailsDaoImpl;
import com.javasm.dao.impl.ProductDaoImpl;
import com.javasm.dao.impl.VIPDaoImpl;
import com.javasm.entity.*;
import com.javasm.util.JDBCUtils;
import com.javasm.vo.ProductVO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * 购买管理
 */
public class BuyService {
    Scanner out = new Scanner(System.in);
    // 获取购物车,Integer:商品的编号
    Map<Integer, ShoppingCart> cartMap = ShoppingCartService.getCartMap();
    OrderDao orderDao = new OrderDaoImpl();
    OrderdetailsDao orderdetailsDao = new OrderdetailsDaoImpl();
    ProductDao productDao = new ProductDaoImpl();
    VIPDao vipDao = new VIPDaoImpl();
    ShoppingCartService sc = new ShoppingCartService();

    public void startMenu() {
        Boolean flag = true;
        while (flag) {
            // 1.选择商品
            choseProduct();
            // 2.选择支付方式
            chosePayType();
            // 3.结算，生成订单
            createOrder();
            System.out.println("是否继续（y|Y继续）？");
            String resultFlag = out.next();
            if (!"y".equals(resultFlag.toLowerCase())) {
                flag = false;
            }
        }
    }

    /**
     * 选择商品
     */
    private void choseProduct() {
        System.out.println("位置：购买管理 --> 选择商品");
        while (true) {
            // 1.显示所有的商品（不要分页）
            showAllProduct();
            // 2.用户输入需要购买的商品编号，验证编号是否正确，如果输入正确继续，如果不正确需要在输入商品编号
            Integer id = buyProductIdCheck();
            // 拿到选择的product类
            Product product = productDao.findProductById(id, null);
            // 3.输入完商品编号，用户需要录入商品的购买数量，验证输入数量是否是数字，需要验证库存是否足够，如果验证失败，商品数量需要重复输入
            Integer num = buyProductNumCheck(id);
            // 将单条订单存入整比订单map中
            sc.saveProdctToCart(product, num);
            // 4.需要用户确定是否“确认购买”，如果是确认购买，进入到支付方式的选择，如果不是就继续选择商品
            System.out.println("是否继续购买:（Y|y继续）");
            String chose = out.next();
            if (!"y".equals(chose.toLowerCase())) {
                break;
            }
        }
    }


    /**
     * 检查购买数量,对比库存
     *
     * @param id
     * @return
     */
    private Integer buyProductNumCheck(Integer id) {
        Integer num = null;
        while (true) {
            System.out.println("请输入要购买的数量");
            String numStr = out.next();
            try {
                num = Integer.parseInt(numStr);
                if (num < 1) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("输入的数量有误请重新输入");
                continue;
            }

            // 验证商品的剩余数量
            Integer numCheck = productDao.productCheckNumById(id, null);
            if (num <= numCheck) {
                break;
            } else {
                System.out.println("商品剩余" + numCheck + ",商品库存不足，请重新输入。。");
            }
        }
        return num;
    }

    /**
     * 检查输入商品id是否存在
     *
     * @return
     */
    private Integer buyProductIdCheck() {
        Integer id = null;
        while (true) {
            System.out.println("请输入要购买的商品ID");
            String idStr = out.next();
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                System.out.println("输入的商品ID有误请重新输入");
                continue;
            }

            // 验证商品ID是否在数据库中
            Boolean checkById = productDao.productCheckById(id);
            if (checkById) {
                break;
            } else {
                System.out.println("输入的商品ID不存在，请重新输入。。");
            }
        }
        return id;
    }

    /**
     * 打印所有商品
     */
    private void showAllProduct() {
        List<ProductVO> list = productDao.findAllProductAndType(null);
        System.out.println("商品编号 \t\t 商品名称 \t\t 商品价格(折扣) \t\t 剩余数量 \t\t 商品类型");
        list.forEach(l -> System.out.println(l.getId() + " \t\t " + l.getPname() + " \t\t " + l.getPrice() + "(" + l.getDiscount() + ") \t\t " + l.getNum() + " \t\t " + l.getTypename()));
    }

    /**
     * 付款方式
     */
    private void chosePayType() {
        System.out.println("位置：购买管理 --> 选择支付");
        // 1.显式购物车中所有的商品
        sc.showCartProduct();
        // 2.用户可以选择购物车中的商品进行修改、删除，可以重复操作，如果用户需要结算，进入到下一步
        confirmShoppingCart();
        // 3.选择支付方式：1.现金支付   2.卡内余额
        // 如果付款方式是：2.卡内余额   用户输入卡号，如果存在就进入到下一步，如果不存在就继续输入卡号
        // 计算用户当前的购物车中的总金额，显示用户的卡内余额，如果卡内余额不足，需要提醒用户切换付款方式(现金支付)
        // 如果付款方式是：1.现金支付  计算用户当前的购物车中的总金额，用户付款之后，计算找零
        checkPayWay();
    }

    private void checkPayWay() {
        Double catMoney = sc.getCatMoney();
        System.out.println("需支付" + catMoney + "元");
        Boolean flag = false;
        while (!flag) {
            System.out.println("请选择支付方式: 1.卡内余额  2.现金支付");
            String chose = out.next();
            if ("1".equals(chose)) {
                while (true) {
                    System.out.println("用卡支付,请输入卡号:");
                    String cardnumber = out.next();
                    UserManage user = vipDao.findUserByCardnumber(cardnumber);
                    if (user == null) {
                        System.out.println("卡号不存在.是否重新输入卡号:(Y|y继续)");
                        String ch = out.next();
                        if (!"y".equals(ch.toLowerCase())) {
                            break;
                        }
                    } else {
                        System.out.println("用户" + user.getVipname() + "余额:" + (user.getMoney()-catMoney));
                        if (catMoney > user.getMoney()) {
                            System.out.println("余额不足,请使用现金支付!");
                            chose = "2";
                            break;
                        } else {
                            System.out.println("支付成功");
                            sc.setUserManage(user);
                            sc.setPaytype(1);
                            flag=true;//支付成功标识
                            break;
                        }
                    }
                }
            }
            if ("2".equals(chose)) {
                while (true) {
                    UserManage user = vipDao.findUserByCardnumber("1000");
                    System.out.println("现金支付,收到的金额:");
                    Double moneyPay = out.nextDouble();
                    if (moneyPay > catMoney) {
                        System.out.println("找零:" + (moneyPay - catMoney) + "元");
                        sc.setUserManage(user);
                        flag=true;//支付成功标识
                        break;
                    } else if (moneyPay.equals(catMoney)) {
                        System.out.println("支付成功");
                        sc.setUserManage(user);
                        flag=true;//支付成功表示
                        break;
                    } else {
                        System.out.println("金额不足,支付失败,重新输入!");
                    }
                }
            }
            if (!("1".equals(chose)||"2".equals(chose))){
                System.out.println("输入有误.请重新输入: ");
            }
        }

    }

    /**
     * 确定购物车订单
     */
    private void confirmShoppingCart() {
        while (true) {
            System.out.println("1.结算 2.修改 3.删除");
            String chose = out.next();
            switch (chose) {
                case "1":
                    return;
                case "2":
                    System.out.println("输入修改的商品ID: ");
                    Integer productupId = out.nextInt();
                    Integer number = buyProductNumCheck(productupId);
                    sc.updateProductToCart(productupId, number);
                    sc.showCartProduct();
                    break;
                case "3":
                    System.out.println("输入要删除的商品ID");
                    Integer productdeId = out.nextInt();
                    sc.deleteProductToCart(productdeId);
                    sc.showCartProduct();
                    break;
                default:
                    System.out.println("输入有误,请重新选择: ");
            }
        }
    }

    /**
     * 结算，生成订单
     */
    private void createOrder() {
        System.out.println("位置：购买管理 --> 生成订单");
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setVipid(sc.getUserManage().getId());
        orderInfo.setPaytype(sc.getPaytype());
        orderInfo.setMoney(sc.getCatMoney());
        Connection connection = JDBCUtils.getConn();
        try {
            connection.setAutoCommit(false);
            //添加大订单
            Integer integer = orderDao.insertOrder(connection, orderInfo);
            if (integer > 0) {
                Set<Integer> keySey = cartMap.keySet();
                for (Integer productId : keySey) {
                    ShoppingCart shoppingCart = cartMap.get(productId);
                    OrderDetails orderDetails = new OrderDetails();
                    orderDetails.setOrderid(integer);
                    orderDetails.setProductid(shoppingCart.getProduct().getId());
                    orderDetails.setPrice(shoppingCart.getProduct().getPrice());
                    orderDetails.setNum(shoppingCart.getCartNumber());
                    orderDetails.setMoney(shoppingCart.getCartPrice());
                    //循环添加小订单
                    Boolean inorder = orderdetailsDao.insertOrderdetails(connection, orderDetails);
                    if (inorder) {
                        //修改产品库存
                        Integer num = productDao.productCheckNumById(connection, productId, null);
                        Boolean flag = productDao.updateProductNumber(connection, productId, (num - shoppingCart.getCartNumber()));
                        if (!flag) {
                            connection.rollback();
                        }
                        if (!sc.getPaytype().equals(0)) {
                            //修改会员余额
                            Boolean vipMoney = vipDao.updateVipMoney(connection, sc.getUserManage().getId(), (sc.getUserManage().getMoney() - sc.getCatMoney()));
                            if (!vipMoney) {
                                connection.rollback();
                            }
                            //修改会员积分
                            Boolean vipJifen = vipDao.updateVipJifen(connection, sc.getUserManage().getId(), (sc.getUserManage().getJifen() + sc.getCatMoney().intValue()));
                            if (!vipJifen) {
                                connection.rollback();
                            }
                        }
                        connection.commit();

                    } else {
                        connection.rollback();
                    }
                }

            }
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        // 1.生成订单
        // 2.通过购物车中的商品，生成订单详情，修改商品库存
        // 3.如果用户的付款方式是卡内余额，扣除用户的卡内余额；如果用户选择卡内余额之和，余额不足，不需要修改卡内余额，
        //   修改用户积分
        // 4.如果上述的任何一个sql操作失败，需要回滚事务（保证Connection是同一个）
        // 5.如果1.2.3.4都成功了，清空购物车中的内容
        sc.clear();
        System.out.println("订单执行完毕");
    }


}
