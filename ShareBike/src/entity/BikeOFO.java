package entity;

import constants.BikeConstants;

public class BikeOFO extends Bike {

    private static int bidNum = 1;//自增序列
    public BikeOFO() {
        super(bidNum,BikeConstants.BIKE_NAME_OFO+bidNum, BikeConstants.BIKE_BORROW_TRUE, "");
        bidNum++;//每次创建新单车,调用时自增
    }
}
