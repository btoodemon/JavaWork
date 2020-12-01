package com.javasm.vo;

import com.javasm.entity.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductTypeVO extends ProductType {
    private String idpra;
    private String typenamepra;
}
