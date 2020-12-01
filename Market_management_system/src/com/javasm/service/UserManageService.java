package com.javasm.service;

import com.javasm.dao.VIPDao;
import com.javasm.dao.impl.VIPDaoImpl;
import com.javasm.entity.UserManage;
import com.javasm.util.PageInfo;

import java.util.List;
import java.util.Scanner;

public class UserManageService {
    Scanner out = new Scanner(System.in);
    VIPDao vipDao = new VIPDaoImpl();

    public void startUserMnageMenu() {
        while (true) {
            System.out.println("位置：会员管理");
            System.out.println("1.查看会员");
            System.out.println("2.添加会员");
            System.out.println("3.修改会员");
            System.out.println("4.删除会员");
            System.out.println("5.返回上一层(主菜单)");
            System.out.println("请选择：");
            String chose = out.next();
            switch (chose) {
                case "1":
                    showUser();
                    break;
                case "2":
                    saveUser();
                    break;
                case "3":
                    updUser();
                    break;
                case "4":
                    deleteUser();
                    break;
                case "5":
                    return;
            }
        }
    }


    private void showUser() {
        boolean flag = true;
        while (flag) {
            System.out.println("位置：会员管理 --> 查看会员");
            System.out.println("1.查询所有");
            System.out.println("2.条件查询");
            System.out.println("3.返回上一层(会员管理)");
            String chose = out.next();
            switch (chose) {
                case "1":
                    showAllUserByPage();
                    break;
                case "2":
                    showUserByCondition();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
            System.out.println("是否继续查询（y|Y继续）？");
            String resultFlag = out.next();
            if (!"y".equals(resultFlag.toLowerCase())) {// 退出查询商品
                flag = false;
            }
        }
    }

    /**
     * 全部查询
     */
    private void showAllUserByPage() {
        //  获取总条数
        Integer total = vipDao.countTotal(null);
        //  计算分页信息
        PageInfo page = new PageInfo();
        page.setTotal(total);
        List<UserManage> list = vipDao.findUserByPage(page, null);
        printUser(list);
        Boolean flag = true;
        while (flag) {
            System.out.println("总页数：" + page.getTotalPage() + " \t 总条数：" + page.getTotal() + " \t 当前页：" + page.getPage());
            System.out.println("1.首页 \t 2.上一页 \t 3.下一页 \t 4.尾页 \t 5.返回上一层(查看会员)  ");
            String chose = out.next();
            switch (chose) {
                case "1":
                    // 给page赋值（当前页）
                    page.setPage(1);
                    list = vipDao.findUserByPage(page, null);
                    printUser(list);
                    break;
                case "2":
                    if (page.hashUpPage()) {
                        list = vipDao.findUserByPage(page, null);
                        printUser(list);
                    }
                    break;
                case "3":
                    if (page.hashNextPage()) {
                        list = vipDao.findUserByPage(page, null);
                        printUser(list);
                    }
                    break;
                case "4":
                    // 给page赋值（当前页）
                    page.setPage(page.getTotalPage());
                    list = vipDao.findUserByPage(page, null);
                    printUser(list);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("输入有误，请重新输入!");
                    break;
            }
        }
    }

    /**
     * 打印方法
     * @param userManages
     */
    private void printUser(List<UserManage> userManages) {
        System.out.println("卡号 \t\t 用户名 \t\t 手机号 \t\t 积分 \t\t 余额");
        userManages.forEach(u -> {
            System.out.println(u.getCardnumber() + " \t\t " + u.getVipname() + " \t\t "
                    + u.getIphone() + " \t\t " + u.getJifen() + " \t\t " + u.getMoney());
        });
    }

    /**
     * 按条件查询
     */
    private void showUserByCondition() {
        boolean flag = true;
        while (flag) {
            System.out.println("请选择查询方式：1.卡号 2.用户名 3.手机号 4.返回上一层（查询商品）");
            String chose = out.next();
            if (chose.equals("4")) {
                break;//  退出循环,结束条件查询
            }
            System.out.println("请选择查询条件：");
            String value = out.next();

            boolean flagNext = true;
            UserManage userManage = new UserManage();
            switch (chose) {
                case "1":
                    userManage.setCardnumber(value);
                    break;
                case "2":
                    userManage.setVipname(value);
                    break;
                case "3":
                    userManage.setIphone(value);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("输入有误，请重新输入");
                    flagNext = false;
                    break;
            }
            if (!flagNext) {
                continue;// 退出本次循环进入到下次循环
            }

            Integer total = vipDao.countTotal(userManage);
            PageInfo pageInfo = new PageInfo();
            pageInfo.setTotal(total);
            List<UserManage> list = vipDao.findUserByPage(pageInfo, userManage);
            printUser(list);

            Boolean flagNextPage = true;
            while (flagNextPage) {
                System.out.println("总页数：" + pageInfo.getTotalPage() + " \t 总条数：" + pageInfo.getTotal() + " \t 当前页：" + pageInfo.getPage());
                System.out.println("1.首页 \t 2.上一页 \t 3.下一页 \t 4.尾页 \t 5.返回上一层(查看商品)  ");
                String chosePage = out.next();
                switch (chosePage) {
                    case "1":
                        // 给page赋值（当前页）
                        pageInfo.setPage(1);
                        list = vipDao.findUserByPage(pageInfo, userManage);
                        printUser(list);
                        break;
                    case "2":
                        if (pageInfo.hashUpPage()) {
                            list = vipDao.findUserByPage(pageInfo, userManage);
                            printUser(list);
                        }
                        break;
                    case "3":
                        if (pageInfo.hashNextPage()) {
                            list = vipDao.findUserByPage(pageInfo, userManage);
                            printUser(list);
                        }
                        break;
                    case "4":
                        // 给page赋值（当前页）
                        pageInfo.setPage(pageInfo.getTotalPage());
                        list = vipDao.findUserByPage(pageInfo, userManage);
                        printUser(list);
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
    }

    /**
     * 添加用户信息
     */
    private void saveUser() {
        while (true) {
            System.out.println("位置：会员管理 --> 添加会员");

            String carnumber = checkCard();
            System.out.println("请输入会员名: ");
            String vipname = out.next();
            System.out.println("请输入手机号: ");
            String iphone = out.next();
            Integer jifen = checkJifen();
            Double money = checkMoney();
            UserManage userManage = new UserManage(carnumber,vipname,iphone,jifen,money,null,null);
            boolean flag = vipDao.insertUser(userManage);

            if (flag) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
            System.out.println("是否继续添加（Y|y继续）");
            String chose = out.next();
            if (!"y".equals(chose.toLowerCase())) {
                break;
            }
        }
    }

    /**
     * 修改用户信息
     */
    private void updUser() {
        while (true) {
            System.out.println("位置: 会员管理 --> 修改会员信息");
            String cardnumber = checkCardExist();
            UserManage userManage = new UserManage();
            Boolean isConfirm = true;
            while (isConfirm) {
                System.out.println("请选择要修改的内容:");
                System.out.println("1.会员卡");
                System.out.println("2.会员名");
                System.out.println("3.手机号");
                System.out.println("4.积分");
                System.out.println("5.余额");
                System.out.println("6.返回并确认修改");
                String chose = out.next();
                switch (chose) {
                    case "1":
                        String cardnumberCh = checkCard();
                        userManage.setCardnumber(cardnumberCh);
                        break;
                    case "2":
                        System.out.println("请输入用户名: ");
                        String vipname = out.next();
                        userManage.setVipname(vipname);
                        break;
                    case "3":
                        System.out.println("请输入手机号: ");
                        String iphone = out.next();
                        userManage.setIphone(iphone);
                        break;
                    case "4":
                        Integer jifen = checkJifen();
                        userManage.setJifen(jifen);
                        break;
                    case "5":
                        Double money = checkMoney();
                        userManage.setMoney(money);
                        break;
                    case "6":
                        isConfirm = false;
                        break;
                    default:
                        System.out.println("输入有误");
                }
            }
            boolean flag = vipDao.updateUser(cardnumber, userManage);
            if (flag) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
            System.out.println("是否继续修改（Y|y继续）");
            String chose = out.next();
            if (!"y".equals(chose.toLowerCase())) {
                break;
            }
        }
    }

    /**
     * 删除用户信息
     */
    private void deleteUser() {
        while (true) {
            System.out.println("位置: 会员管理 --> 删除会员");
            String cardnumber = checkCardExist();
            System.out.println("确定删除" + cardnumber + "?(q确定)");
            String makesuir = out.next();
            if ("q".equals(makesuir)) {
                boolean flag = vipDao.deleteUser(cardnumber);
                if (flag) {
                    System.out.println("删除成功");
                } else {
                    System.out.println("删除失败");
                }
            }
            System.out.println("是否继续删除（Y|y继续）");
            String chose = out.next();
            if (!"y".equals(chose.toLowerCase())) {
                break;
            }
        }
    }

    private Integer checkJifen() {
        Integer jifen = null;
        while (true) {
            System.out.println("请输入用户积分：");
            String jifenStr = out.next();
            try {
                jifen = Integer.parseInt(jifenStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入的积分格式有误，请重新输入！");
            }
        }
        return jifen;
    }
    private Double checkMoney() {
        Double money = null;
        while (true) {
            System.out.println("请输入用户余额：");
            String moneyStr = out.next();
            try {
                money = Double.parseDouble(moneyStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入的余额格式有误，请重新输入！");
            }
        }
        return money;
    }
    private String checkCard() {
        String cardnumber = "";
        while (true) {
            System.out.println("请输入用户卡号：");
            cardnumber = out.next();
            // 1.2验证用户卡号是否存在
            UserManage userManage = vipDao.findUserByCardnumber(cardnumber);
            if (userManage != null) {//  用户卡号已存在
                System.out.println("用户卡号已存在，请重新输入");
            } else {
                break;
            }
        }
        return cardnumber;
    }
    private String checkCardExist() {
        String cardnumber = "";
        while (true) {
            System.out.println("请输入用户卡号：");
            cardnumber = out.next();
            // 1.2验证用户卡号是否存在
            UserManage userManage = vipDao.findUserByCardnumber(cardnumber);
            if (userManage != null) {//  用户卡号已存在
                break;
            } else {
                System.out.println("用户卡号不存在，请重新输入");
            }
        }
        return cardnumber;
    }


}
