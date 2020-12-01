package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 购物车(描述会员在购买商品时的购买信息)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

    private Integer cartNumber;
    private Double cartPrice;
    private Product product;


}
