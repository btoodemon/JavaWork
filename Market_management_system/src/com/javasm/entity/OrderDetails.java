package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetails {

    private Integer id;//单条商品在订单上的id
    private Integer orderid;//订单的id
    private Integer productid;//商品的id
    private Double price;//商品单价
    private Integer num;//商品的数量
    private Double money;//商品的价格

    public OrderDetails(Integer orderid, Integer productid, Double price, Integer num, Double money) {
        this.orderid = orderid;
        this.productid = productid;
        this.price = price;
        this.num = num;
        this.money = money;
    }
}
