package com.javasm.vo;

import com.javasm.entity.OrderInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoVO extends OrderInfo {
    private String cardnumber;
    private String vipname;
}
