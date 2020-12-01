package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderInfo {

    private Integer id;//订单id
    private Integer vipid;//会员id
    private Timestamp orderdate;//订单时间
    private Integer paytype;//支付方式 （0-现金  or  1-余额）
    private Double money;//总金额

    public OrderInfo(Integer vipid, Timestamp orderdate, Integer paytype) {
        this.vipid = vipid;
        this.orderdate = orderdate;
        this.paytype = paytype;
    }

    public OrderInfo(Integer vipid, Timestamp orderdate, Integer paytype, Double money) {
        this.vipid = vipid;
        this.orderdate = orderdate;
        this.paytype = paytype;
        this.money = money;
    }
}
