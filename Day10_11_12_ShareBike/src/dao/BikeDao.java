package dao;

import entity.Company;

public interface BikeDao {
    /**
     * 查询所有车辆
     */
    void seletAllBike(Company company);
    /**
     * 投放车辆
     */
    void putBike(Company company);

    /**
     * 删除车辆
     */
    void deleteBike(Company company);

    /**
     * 借出车辆
     */
    void borrowBike(Company company);

    /**
     * 归还车辆
     */
    void returnBike(Company company);

    /**
     * 车辆排行榜
     */
    void top();


}
