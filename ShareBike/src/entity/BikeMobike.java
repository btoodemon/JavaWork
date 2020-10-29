package entity;

import constants.BikeConstants;

public class BikeMobike extends Bike{
    private static int bidNum = 1;//自增序列
    public BikeMobike() {
        super(bidNum,BikeConstants.BIKE_NAME_MOBIKE+bidNum, BikeConstants.BIKE_BORROW_TRUE, "");
        bidNum++;//每次创建新单车,调用时自增
    }

}
