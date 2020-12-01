package com.javasm.service;

import com.javasm.dao.OrderdetailsDao;
import com.javasm.dao.ProductTypeDao;
import com.javasm.dao.VIPDao;
import com.javasm.dao.impl.OrderdetailsDaoImpl;
import com.javasm.dao.impl.ProductTypeDaoImpl;
import com.javasm.dao.impl.VIPDaoImpl;
import com.javasm.entity.ProductType;
import com.javasm.entity.UserManage;
import com.javasm.vo.RankingVO;

import java.sql.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class RankingService {
    Scanner out = new Scanner(System.in);
    OrderdetailsDao orderdetailsDao = new OrderdetailsDaoImpl();
    ProductTypeDao productTypeDao = new ProductTypeDaoImpl();
    VIPDao vipDao = new VIPDaoImpl();

    public void startRankingMenu() {
        System.out.println("1.销量总排行前十");
        System.out.println("2.按时间销量排行");
        System.out.println("3.按类型销量排行");
        System.out.println("4.按选择条件排行");
        System.out.println("请输入要查看的排行:");
        String chose = out.next();
        switch (chose) {
            case "1":
                rankingAll();
                break;
            case "2":
                rankingTime();
                break;
            case "3":
                rankingType();
                break;
            case "4":
                rankingCondition();
            default:
        }

    }

    private void rankingCondition() {
        RankingVO rankingVO = new RankingVO();
        Boolean isConfirm = true;
        String beTime = "2000-1";
        String enTime = "2050-12";
        while (isConfirm) {
            System.out.println("请输入要排名的条件: ");
            System.out.println("1.二级类型");
            System.out.println("2.时间");
            System.out.println("3.会员卡号");
            //System.out.println("*.价格区间");
            System.out.println("4.确定条件:");
            String chose = out.next();
            switch (chose) {
                case "1":
                    String typename = checkTypeNameExist();
                    rankingVO.setTypename(typename);
                    break;
                case "2":
                    System.out.println("起始时间:");
                    beTime = checkInputDate();
                    System.out.println("结束时间:");
                    enTime = checkInputDate();
                    break;
                case "3":
                    String card = checkCardExist();
                    rankingVO.setCardnumber(card);
                    break;
                case "4":
                    isConfirm = false;
                    break;
                default:
                    System.out.println("输入有误");
            }
        }
        List<RankingVO> list = orderdetailsDao.rankingByCondition(rankingVO, beTime, enTime);
        showRankingCondition(list,rankingVO);
    }

    private void showRankingCondition(List<RankingVO> list,RankingVO rankingVO) {
        Boolean iscard =false;
        System.out.print("销量\t\t商品ID\t商品名\t\t二级类别\t\t一级类别");
        if (rankingVO.getCardnumber()!=null && !"".equals(rankingVO.getCardnumber())){
            System.out.print("\t\t会员卡号");
            iscard=true;
        }
        System.out.print("\t\t时间(只供时间功能检查)");
        System.out.println();

        Iterator<RankingVO> iterator=list.iterator();
        while (iterator.hasNext()){
            RankingVO r=iterator.next();
            System.out.print(r.getSumsell()+"\t\t"+r.getProductid()+"\t"+r.getPname()+"\t\t\t"+r.getTypename()+"\t\t"+r.getTypenamepra());
            if (iscard){
                System.out.print("\t\t"+r.getCardnumber());
            }
            System.out.print("\t"+r.getOrderdate());
            System.out.println();
        }

    }

    private String checkCardExist() {
        String cardnumber = "";
        while (true) {
            System.out.println("请输入用户卡号： ");
            cardnumber = out.next();
            // 验证用户卡号是否存在
            UserManage userManage = vipDao.findUserByCardnumber(cardnumber);
            if (userManage != null) {//  用户卡号已存在
                break;
            } else {
                System.out.println("用户卡号不存在，请重新输入");
            }
        }
        return cardnumber;
    }

    private String checkInputDate() {
        System.out.println("请输入年(2000-2050): ");
        String yy = out.next();
        System.out.println("请输入月(1-12):");
        String mm = out.next();
        return yy.concat("-"+mm);

    }

    private String checkTypeNameExist() {
        String typename = "";
        while (true) {
            System.out.println("请输入二级商品类型名称: ");
            typename = out.next();
            ProductType productType = productTypeDao.findTypeByTypename(typename);
            if (productType != null) {
                ProductType parent = productTypeDao.findTypeidByIdAndNotParent(productType.getParentId());
                if(parent !=null){
                    break;
                }else {
                    System.out.println("输入的为一级商品类型,请重新输入");
                }

            } else {
                System.out.println("二级商品类型不存在,请重新输入");
            }
        }
        return typename;
    }

    private void rankingType() {
        RankingVO rankingVO = new RankingVO();
        System.out.println("请输入要查询的类型名:");
        String type = out.next();
        rankingVO.setTypename(type);
        List<RankingVO> list = orderdetailsDao.rankingByType(rankingVO);
        showRankingType(list);
    }

    private void showRankingType(List<RankingVO> list) {
        System.out.println("类别\t\t商品ID\t\t商品名\t\t销售额");
        list.forEach(r -> {
            System.out.println(r.getTypename() + "\t\t" + r.getProductid() + "\t\t\t" + r.getPname() + "\t\t" + r.getSumsell());
        });
    }

    /**
     * 按月份销量排行
     */
    private void rankingTime() {
        RankingVO rankingVO = new RankingVO();
        System.out.println("请输入起始年份:(2000-2050)");
        Integer by = out.nextInt();
        System.out.println("请输入起始月份:(1-12)");
        Integer bm = out.nextInt();
        System.out.println("请输入结束年份:(2000-2050)");
        Integer ey = out.nextInt();
        System.out.println("请输入结束月份:(1-12)");
        Integer em = out.nextInt();
        List<RankingVO> list = orderdetailsDao.rankingByTime(rankingVO, by, bm, ey, em);
        showRankingTime(list);
    }

    /**
     * 打印按时间排行
     *
     * @param list
     */
    private void showRankingTime(List<RankingVO> list) {
        System.out.println("销售额\t商品ID\t商品名\t\t\t销售时间(不需要,只用于验证)");
        list.forEach(r -> {
            System.out.println(r.getSumsell() + "\t\t" + r.getProductid() + "\t\t" + r.getPname() + "\t\t\t" + r.getOrderdate());
        });
    }

    /**
     * 销量总排行前十
     */
    private void rankingAll() {
        RankingVO rankingVO = new RankingVO();
        List<RankingVO> list = orderdetailsDao.rankingByProduct(rankingVO);
        showRankingAll(list);
    }

    private void showRankingAll(List<RankingVO> list) {
        System.out.println("销售额\t商品ID\t商品名\t\t一级类型\t\t二级类型\t\t价格");
        list.forEach(r -> {
            System.out.println(r.getSumsell() + "\t\t" + r.getProductid() + "\t\t" + r.getPname()
                    + "\t\t" + r.getTypenamepra() + "\t\t" + r.getTypename() + "\t\t" + r.getPrice());
        });
    }
}
