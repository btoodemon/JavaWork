package com.javasm.vo;

import com.javasm.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品表查询的扩展类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO extends Product {

    private String typename;

}
