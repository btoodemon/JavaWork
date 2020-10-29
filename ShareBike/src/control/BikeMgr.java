package control;

import entity.*;

/**
 * 程序控制入口
 */
public class BikeMgr {
    public static Company[] companies = new Company[3];
    /**
     * 初始化公司以及车辆
     */
    public void initial(){
        //初始化OFO车辆数组
        Bike[] ofoBikes = new Bike[2];
        ofoBikes[0] = new BikeOFO();
        ofoBikes[1] = new BikeOFO();
        //实例化OFO公司对象
        Company ofoCompany = new Company(1,"OFO单车公司",ofoBikes,2,0);

        Bike[] helloBikes = new Bike[2];
        helloBikes[0] = new BikeHello();
        helloBikes[1] = new BikeHello();
        //实例化OFO公司对象
        Company helloCompany = new Company(2,"HELLO单车公司",helloBikes,2,0);

        Bike[] mobikeBikes = new Bike[2];
        mobikeBikes[0] = new BikeMobike();
        mobikeBikes[1] = new BikeMobike();
        //实例化OFO公司对象
        Company mobikeCompany = new Company(3,"MOBIKE单车公司",mobikeBikes,2,0);


        companies[0] = ofoCompany;
        companies[1] = helloCompany;
        companies[2] = mobikeCompany;
    }

    public static void main(String[] args) {
        new BikeMgr().initial();
        new Start().startMenu();
    }


}
