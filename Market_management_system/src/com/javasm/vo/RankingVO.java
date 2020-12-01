package com.javasm.vo;

import com.javasm.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RankingVO extends OrderDetails {
    private String pname;
    private String typename;
    private String typenamepra;
    private Integer sumsell;
    private Timestamp orderdate;//订单时间
    private Double price;//价格
    private String cardnumber;//会员卡
}
