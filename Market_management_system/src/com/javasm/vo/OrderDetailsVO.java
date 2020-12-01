package com.javasm.vo;

import com.javasm.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsVO extends OrderDetails {
    private Timestamp orderdate;

}
