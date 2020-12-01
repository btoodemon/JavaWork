package com.javasm.dao.impl;

import com.javasm.dao.ProductTypeDao;
import com.javasm.entity.Product;
import com.javasm.entity.ProductType;
import com.javasm.util.JDBCUtils;
import com.javasm.util.PageInfo;
import com.javasm.vo.ProductTypeVO;


import java.util.List;

public class ProductTypeDaoImpl implements ProductTypeDao {
    @Override
    public ProductType findPTByIdAndIsParent(Integer id) {
        String sql = "select * from producttype where id = ? and flagparent = 0 ";
        return JDBCUtils.get(sql, ProductType.class, id);
    }

    @Override
    public List<ProductTypeVO> findProductTypeByPage(PageInfo pageInfo, ProductTypeVO productTypeVO) {
        StringBuilder sql = new StringBuilder("select p1.id,p1.typename,p2.id idpra,p2.typename typenamepra from producttype p1 INNER JOIN producttype p2 ON p1.id=p2.Parentid ORDER BY p1.id");
        sql.append(" limit ?,? ");
        return JDBCUtils.getList(sql.toString(),ProductTypeVO.class,pageInfo.getNowIndex(),pageInfo.getRows());
    }

    @Override
    public ProductType findTypeByTypename(String typename) {
        String sql = "select * from producttype where typename = ?";
        return JDBCUtils.get(sql, ProductType.class, typename);
    }

    @Override
    public ProductType findTypeidByIdAndNotParent(Integer id) {
        String sql = "select * from producttype where id = ? and flagparent = 1 ";
        return JDBCUtils.get(sql, ProductType.class, id);
    }

    @Override
    public Integer countTotal() {
        String sql = "select count(1) from producttype p1 INNER JOIN producttype p2 ON p1.id=p2.Parentid ORDER BY p1.id ";
        return JDBCUtils.getCount(sql);
    }

    @Override
    public Boolean insertProductType(ProductType productType) {
        String sql = "insert into producttype values(null,?,?,?,null,null)";
        int result = JDBCUtils.insert(sql, productType.getParentId(),productType.getTypename(),productType.getFlagparent());
        return result > 0;
    }

    @Override
    public Boolean updateProductType(String typename, ProductType productType) {
        StringBuilder sql = new StringBuilder("UPDATE producttype SET id=id");

        if (productType.getTypename() != null && !"".equals(productType.getTypename())) {
            sql.append(",typename='" + productType.getTypename() + "'");
        }
        if (productType.getParentId() != null && !"".equals(productType.getParentId())) {
            sql.append(",Parentid=" + productType.getParentId());
        }

        sql.append(" where typename=?");

        int result = JDBCUtils.update(sql.toString(), typename);
        return result > 0;
    }

    @Override
    public Boolean deleteProductType(String typename) {
        String sql = "DELETE FROM producttype where typename= ?";
        int result = JDBCUtils.delete(sql, typename);
        return result > 0;
    }

    @Override
    public Integer deleteProductTypeCheckForTypeid(String typename) {
        String sqlGetId = "select * from producttype where typename = ?";
        Integer typeId = JDBCUtils.get(sqlGetId, ProductType.class, typename).getId();
        return typeId;
    }

    @Override
    public Boolean deleteProductTypeCheckForPra(Integer typeid) {
        String sql = "SELECT COUNT(1) FROM producttype t1 INNER JOIN producttype t2 ON t1.Parentid=t2.id WHERE t2.id=?";
        return JDBCUtils.getCount(sql,typeid)>0;
    }
}
