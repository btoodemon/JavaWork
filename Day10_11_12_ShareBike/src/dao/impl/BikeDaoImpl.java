package dao.impl;

import constants.BikeConstants;
import control.BikeMgr;
import dao.BikeDao;
import entity.*;
import util.DateUtils;
import util.MoneyUtils;

import java.util.Arrays;
import java.util.Scanner;

public class BikeDaoImpl implements BikeDao {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void seletAllBike(Company company) {
        System.out.println("查询车辆");
        System.out.println("公司编号\t公司名称\t\t单车数量\t借出次数");
        System.out.println(company.getCompanyId() + "\t\t" + company.getCompanyName()
                + "\t" + company.getSum() + "\t\t" + company.getCount());
        Bike[] bikes = company.getBikes();
        System.out.println("单车编号\t单车名称\t\t单车状态\t借出时间");
        for (Bike bike : bikes) {
            String status = bike.getStatus() == BikeConstants.BIKE_BORROW_TRUE ? "可借" : "已借出";
            System.out.println(bike.getBid() + "\t\t" + bike.getBname() + "\t\t" + status + "\t" + bike.getBorrowTime());
        }
    }

    @Override
    public void putBike(Company company) {
        System.out.println("投放车辆");
        Bike[] bikes = company.getBikes();
        System.out.println("请输入需要投放的车辆的数量:");
        int input = scanner.nextInt();
        int newLength = bikes.length + input;
        Bike[] newbikes = Arrays.copyOf(bikes, newLength);
        for (int i = bikes.length; i < newLength; i++) {
            if (company.getCompanyId() == 1) {
                newbikes[i] = new BikeOFO();
            } else if (company.getCompanyId() == 2) {
                newbikes[i] = new BikeHello();
            } else {
                newbikes[i] = new BikeMobike();
            }
        }
        company.setBikes(newbikes);
        company.setSum(newLength);
        System.out.println("投放完毕,共投放" + input + "辆单车");
    }

    @Override
    public void deleteBike(Company company) {
        System.out.println("删除车辆");
        Bike[] bikes = company.getBikes();
        seletAllBike(company);
        System.out.println("请输入需要删除的单车编号:");
        int input = scanner.nextInt();
        if (bikes[input-1].getStatus() == 0) {
            System.out.println("您要删除的单车已借出!删除失败.");
        } else if (input < 1 || input > company.getSum()) {
            System.out.println("您输入的单车编号不存在!");
        } else {
            System.out.println(bikes.length);
            if(input != company.getSum()){
                for (int i = input; i < bikes.length; i++) {
                    bikes[i - 1].setBname(bikes[i].getBname());
                    bikes[i - 1].setStatus(bikes[i].getStatus());
                    bikes[i - 1].setBorrowTime(bikes[i].getBorrowTime());
                }
            }
            Bike[] newbikes = Arrays.copyOf(bikes, bikes.length - 1);
            company.setBikes(newbikes);
            System.out.println("删除成功");
            company.setSum(bikes.length - 1);
        }


    }

    @Override
    public void borrowBike(Company company) {
        System.out.println("借出车辆");
        Bike[] bikes = company.getBikes();
        seletAllBike(company);
        System.out.println("请输入要借出的单车编号:");
        int input = scanner.nextInt();
        if (bikes[input - 1].getStatus() == 0) {
            System.out.println("借出失败!您要借出的单车已被骑走");
        } else if (input < 1 || input > company.getSum()) {
            System.out.println("您输入的单车编号不存在!");
        } else {
            bikes[input - 1].setStatus(BikeConstants.BIKE_BORROW_FLASE);
            bikes[input - 1].setBorrowTime(DateUtils.getTimeNow());
            System.out.print("您于" + DateUtils.getTimeNow() + "  将 ");
            System.out.println("[" + bikes[input - 1].getBname() + "]    借出成功");
            company.setBikes(bikes);
            company.setCount(company.getCount()+1);
        }
    }

    @Override
    public void returnBike(Company company) {
        System.out.println("归还车辆");
        System.out.println("请输入要归还的单车编号");
        int input = scanner.nextInt();
        Bike[] bikes = company.getBikes();
        if (bikes[input - 1].getStatus() == 1) {
            System.out.println("失败!您要归还的单车并未借出!");
        } else if (input < 1 || input > company.getSum()) {
            System.out.println("您输入的单车编号不存在!");
        } else {
            System.out.print("您于" + DateUtils.getTimeNow() + "  将 ");
            System.out.println("[" + bikes[input - 1].getBname() + "]    归还成功");
            int time = DateUtils.getTime(bikes[input - 1].getBorrowTime(), DateUtils.getTimeNow());
            System.out.println("用车时间[" + time + "分钟]   请扫码支付 [" + MoneyUtils.countMoney(time) + "元]");
            bikes[input - 1].setStatus(BikeConstants.BIKE_BORROW_TRUE);
            bikes[input - 1].setBorrowTime("");
        }
    }

    @Override
    public void top() {
        System.out.println("车辆排行");
        System.out.println("排名\t公司名称\t\t\t借车次数");
        Company[] companies = new Company[3];
        for (int i = 0; i < companies.length; i++) {
            companies[i] = BikeMgr.companies[i];
        }
        for (int i = 0; i < companies.length - 1; i++) {
            for (int j = i + 1; j < companies.length; j++) {
                if (companies[i].getCount() < companies[j].getCount()) {
                    Company temp = companies[i];
                    companies[i] = companies[j];
                    companies[j] = temp;
                }
            }
        }
        for (int i = 0; i < companies.length; i++) {
            System.out.println((i + 1) + "\t" + companies[i].getCompanyName() + "\t\t" + companies[i].getCount());
        }


    }
}
