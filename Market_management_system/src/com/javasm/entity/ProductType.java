package com.javasm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductType {

    private Integer id;
    private Integer parentId;
    private String typename;
    private Integer flagparent;
    private String createTime;
    private String updateTime;

    public ProductType(Integer parentId, String typename, Integer flagparent, String createTime, String updateTime) {
        this.parentId = parentId;
        this.typename = typename;
        this.flagparent = flagparent;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ProductType(Integer id, String typename) {
        this.id = id;
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", typename='" + typename + '\'' +
                ", flagparent=" + flagparent +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
