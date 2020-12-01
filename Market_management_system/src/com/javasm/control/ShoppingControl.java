package com.javasm.control;

import com.javasm.entity.Userinfo;
import com.javasm.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingControl {

    // 存储用户信息
    private static final List<Userinfo> userList = new ArrayList<>();
    // 登录人
    private Userinfo loginUser = null;
    Scanner out = new Scanner(System.in);

    /**
     * 初始化用户信息（管理员和收银员）
     */
    private void initUserinfo() {
        userList.add(new Userinfo("admin", "123456", 1));
        userList.add(new Userinfo("shouyin", "123456", 2));
    }

    /**
     * 登录(最多登录3次)
     */
    private void login() {
        boolean flag = true;
        for (int i = 0; i < 3; i++) {
            System.out.println("=====XXXX超市管理系统=====");
            System.out.println("==========请登录=========");
            System.out.println("请输入账号：");
            String userName = out.next();
            System.out.println("请输入密码：");
            String pwd = out.next();

            for (Userinfo userinfo : userList) {
                if (userinfo.getUsername().equals(userName) && userinfo.getPwd().equals(pwd)) {
                    flag = false;
                    loginUser = userinfo;
                    break;// 退出内层循环
                }
            }
            if (!flag) {
                break;// 退出外层循环
            }
        }
        if (!flag) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }

    /**
     * 选择菜单
     */
    private void choseMenu() {
        if (loginUser != null) {
            boolean flag = true;
            while (flag) {
                System.out.println("==============================");
                System.out.println("=====欢迎进入XXXX超市系统=====");
                System.out.println("==============================");
                if (loginUser.getRoleid() == 1) {//  管理员
                    System.out.println("1.商品类型管理");
                    System.out.println("2.商品管理");
                    System.out.println("3.会员管理");
                }
                if (loginUser.getRoleid() == 2) {//  收银员
                    System.out.println("1.购买管理");
                    System.out.println("2.订单管理");
                    System.out.println("3.排行统计");
                }
                System.out.println("4.退出系统");
                System.out.println("请选择菜单：");
                String chose = out.next();

                if (loginUser.getRoleid() == 1) {//  管理员
                    switch (chose) {
                        case "1":
                            System.out.println("商品类型管理");
                            new ProductTypeService().startProductMenu();
                            break;
                        case "2":
                            System.out.println("商品管理");
                            new ProductService().startProductMenu();
                            break;
                        case "3":
                            System.out.println("会员管理");
                            new UserManageService().startUserMnageMenu();
                            break;
                        case "4":
                            System.out.println("结束访问");
                            flag = false;
                            break;
                        default:
                            System.out.println("输入有误，请重新输入");
                            break;
                    }
                }
                if (loginUser.getRoleid() == 2) {//  收银员
                    switch (chose) {
                        case "1":
                            System.out.println("购买管理");
                            new BuyService().startMenu();
                            break;
                        case "2":
                            System.out.println("订单管理");
                            new OrderService().startOrderMenu();
                            break;
                        case "3":
                            System.out.println("排行统计");
                            new RankingService().startRankingMenu();
                            break;
                        case "4":
                            System.out.println("结束访问");
                            flag = false;
                            break;
                        default:
                            System.out.println("输入有误，请重新输入");
                            break;
                    }
                }
            }
        }
    }

    /**
     * 启动项目
     */
    public void startMenu() {
        initUserinfo();
        login();
        choseMenu();
    }

}
