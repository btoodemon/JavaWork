package control;

import dao.BikeDao;
import dao.impl.BikeDaoImpl;
import entity.Company;

import java.util.Scanner;

public class Start {
    Scanner scanner = new Scanner(System.in);
    //创建数据操作类
    BikeDao bikeDao = new BikeDaoImpl();

    public void startMenu() {
        System.out.println("  欢迎使用迷你共享单车管理系统");
        System.out.println("******************************");
        System.out.println("\t1.投放Bike");
        System.out.println("\t2.查看Bike");
        System.out.println("\t3.删除Bike");
        System.out.println("\t4.借出Bike");
        System.out.println("\t5.归还Bike");
        System.out.println("\t6.Bike排行榜");
        System.out.println("\t7.退出");
        System.out.println("******************************");
        System.out.println("请选择:");
        int input = scanner.nextInt();
        selectMenu(input);
    }

    /**
     * 选择菜单
     *
     * @param input 用户输入
     */
    public void selectMenu(int input) {
        switch (input) {
            case 1://投放
                bikeDao.putBike(selectCompany());
                break;
            case 2://查看
                bikeDao.seletAllBike(selectCompany());
                break;
            case 3://删除
                bikeDao.deleteBike(selectCompany());
                break;
            case 4://借出
                bikeDao.borrowBike(selectCompany());
                break;
            case 5://归还
                bikeDao.returnBike(selectCompany());
                break;
            case 6://排行榜
                bikeDao.top();
                break;
            case 7://退出
                break;
            default://默认
                break;
        }
        isContinue();

    }
    /**
     * 选择公司
     */
    public Company selectCompany(){
        for (Company company:BikeMgr.companies){
            System.out.println(company.getCompanyId()+" : "+company.getCompanyName());
        }
        System.out.println("请选择需要操作的公司 : ");
        int input = scanner.nextInt();
        Company company = BikeMgr.companies[input-1];
        return company;
    }

    /**
     * 是否继续
     */
    public void isContinue(){
        System.out.println("是否要继续? (y/n)");
        String input = scanner.next();
        if("y".equals(input)){
            startMenu();
        }
    }
}
