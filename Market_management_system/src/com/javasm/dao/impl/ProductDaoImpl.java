package com.javasm.dao.impl;

import com.javasm.dao.ProductDao;
import com.javasm.entity.Product;
import com.javasm.util.JDBCUtils;
import com.javasm.util.PageInfo;
import com.javasm.vo.ProductVO;

import java.sql.Connection;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public Boolean updateProductNumber(Connection conn, Integer id, Integer num) throws Exception {
        String sql = "UPDATE product SET num=? where id=?";
        boolean flag = JDBCUtils.update(conn, sql, num,id) > 0;
        if (!flag) {
            throw new Exception("失败");
        }
        return flag;
    }

    @Override
    public List<ProductVO> findProductByPageAndProduct(PageInfo pageInfo, ProductVO productVO) {
        StringBuilder sql = new StringBuilder("select p.*,pt.typename from product p,producttype pt where p.typeid=pt.id ");
        if (productVO != null) {
            if (productVO.getPname() != null && !"".equals(productVO.getPname())) {
                sql.append(" and p.pname like '%" + productVO.getPname() + "%'");
            }
            if (productVO.getTypename() != null && !"".equals(productVO.getTypename())) {
                sql.append(" and pt.typename like '%" + productVO.getTypename() + "%'");
            }
        }
        sql.append(" limit ?,? ");
        return JDBCUtils.getList(sql.toString(), ProductVO.class, pageInfo.getNowIndex(), pageInfo.getRows());
    }

    @Override
    public Integer countTotal(ProductVO productVO) {
        StringBuilder sql = new StringBuilder("select count(1) from product p,producttype pt where p.typeid=pt.id ");
        if (productVO != null) {
            if (productVO.getPname() != null && !"".equals(productVO.getPname())) {
                sql.append(" and p.pname like '%" + productVO.getPname() + "%'");
            }
            if (productVO.getTypename() != null && !"".equals(productVO.getTypename())) {
                sql.append(" and pt.typename like '%" + productVO.getTypename() + "%'");
            }
        }
        return JDBCUtils.getCount(sql.toString());
    }

    @Override
    public List<ProductVO> findAllProductAndType(ProductVO productVO) {
        String sql = "select p.*,pt.typename from product p,producttype pt where p.typeid=pt.id ";
        return JDBCUtils.getList(sql, ProductVO.class);
    }

    @Override
    public Product findProductByPname(String pname) {
        String sql = "select * from product where pname = ?";
        return JDBCUtils.get(sql, Product.class, pname);
    }

    @Override
    public Boolean insertProduct(Product product) {
        String sql = "insert into product values(null,?,?,?,?,?,1)";
        int result = JDBCUtils.insert(sql, product.getPname(), product.getPrice(), product.getNum(), product.getDiscount(), product.getTypeid());
        return result > 0;
    }

    @Override
    public Boolean updateProduct(String pname, Product product) {
        StringBuilder sql = new StringBuilder("UPDATE product SET id=id");

        if (product.getPname() != null && !"".equals(product.getPname())) {
            sql.append(",pname='" + product.getPname() + "'");
        }
        if (product.getPrice() != null && !"".equals(product.getPrice())) {
            sql.append(",price=" + product.getPrice());
        }
        if (product.getNum() != null && !"".equals(product.getNum())) {
            sql.append(",num=" + product.getNum());
        }
        if (product.getDiscount() != null && !"".equals(product.getDiscount())) {
            sql.append(",discount=" + product.getDiscount());
        }
        if (product.getTypeid() != null && !"".equals(product.getTypeid())) {
            sql.append(",typeid=" + product.getTypeid());
        }
        if (product.getState() != null && !"".equals(product.getState())) {
            sql.append(",state=" + product.getState());
        }
        sql.append(" where pname=?");

        int result = JDBCUtils.update(sql.toString(), pname);
        return result > 0;
    }

    @Override
    public Boolean deleteProduct(String pname) {
        String sql = "DELETE FROM product where pname= ?";
        int result = JDBCUtils.delete(sql, pname);
        return result > 0;
    }

    @Override
    public Boolean productCheckByType(Integer typeid) {
        String sql = "select count(1) from product where typeid = ?";
        int result = JDBCUtils.getCount(sql, typeid);
        return result > 0;
    }


    @Override
    public Boolean productCheckById(Integer id) {
        String sql = "select count(1) from product where id = ?";
        int result = JDBCUtils.getCount(sql, id);
        return result > 0;
    }

    @Override
    public Integer productCheckNumById(Integer id,Product product) {
        String sql = "select num from product where id = ?";
        product = JDBCUtils.get(sql, Product.class, id);
        return product.getNum();
    }

    @Override
    public Integer productCheckNumById(Connection connection, Integer id, Product product) {
        String sql = "select num from product where id = ?";
        product = JDBCUtils.get(connection,sql, Product.class, id);
        return product.getNum();
    }

    @Override
    public Product findProductById(Integer id,Product product) {
        String sql = "select * from product where id = ?";
        product = JDBCUtils.get(sql,Product.class,id);
        return product;
    }
}
