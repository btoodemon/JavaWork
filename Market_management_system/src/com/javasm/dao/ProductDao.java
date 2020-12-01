package com.javasm.dao;

import com.javasm.entity.Product;
import com.javasm.util.PageInfo;
import com.javasm.vo.ProductVO;

import java.sql.Connection;
import java.util.List;

public interface ProductDao {
    /**
     * 订单修改商品库存
     * @param conn
     * @param id
     * @param num
     * @return
     */
    Boolean updateProductNumber(Connection conn,Integer id,Integer num) throws Exception;
    /**
     * 分页添加查询
     *
     * @param pageInfo  分页类
     * @param productVO 查询条件
     * @return
     */
    List<ProductVO> findProductByPageAndProduct(PageInfo pageInfo, ProductVO productVO);

    /**
     * 无分页显示商品和类型
     * @param productVO
     * @return
     */
    List<ProductVO> findAllProductAndType(ProductVO productVO);

    /**
     * 统计总数量
     *
     * @param productVO 查询条件
     * @return
     */
    Integer countTotal(ProductVO productVO);

    /**
     * 通过商品名称查询商品
     *
     * @param pname
     * @return
     */
    Product findProductByPname(String pname);

    /**
     * 添加商品
     *
     * @param product
     * @return
     */
    Boolean insertProduct(Product product);

    /**
     * 修改商品
     * @param product
     * @return
     */
    Boolean updateProduct(String pname,Product product);

    /**
     * 删除商品
     * @param pname
     * @return
     */
    Boolean deleteProduct(String pname);

    /**
     * 以商品类型id查找商品
     * @param typeid
     * @return
     */
    Boolean productCheckByType(Integer typeid);

    /**
     * 以商品id查找商品
     * @param id
     * @return
     */
    Boolean productCheckById(Integer id);

    /**
     * 以商品id返回商品类
     * @param id
     * @return
     */
    Product findProductById(Integer id,Product product);

    /**
     * 检查商品数量
     * @param id
     * @return
     */
    Integer productCheckNumById(Integer id,Product product);

    /**
     * 检查商品数量,用于修改数量
     * @param connection
     * @param id
     * @param product
     * @return
     */
    Integer productCheckNumById(Connection connection,Integer id,Product product);



}
