package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    private Integer id;
    private String pname;
    private Double price;
    private Integer num;
    private Integer discount;
    private Integer typeid;
    private Integer state;

    public Product(String pname, Double price, Integer num, Integer discount, Integer typeid, Integer state) {
        this.pname = pname;
        this.price = price;
        this.num = num;
        this.discount = discount;
        this.typeid = typeid;
        this.state = state;
    }

    public Product(String pname, Double price, Integer num, Integer discount, Integer typeid) {
        this.pname = pname;
        this.price = price;
        this.num = num;
        this.discount = discount;
        this.typeid = typeid;
    }

    @Override
    public String toString() {
        String stateMessage = "上架";
        if (state == 2) {
            stateMessage = "下架";
        }

        return "Product{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", discount=" + discount +
                ", typeid=" + typeid +
                ", state=" + stateMessage +
                '}';
    }

}
