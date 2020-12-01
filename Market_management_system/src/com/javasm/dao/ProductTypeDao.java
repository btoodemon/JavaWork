package com.javasm.dao;

import com.javasm.entity.ProductType;
import com.javasm.util.PageInfo;
import com.javasm.vo.ProductTypeVO;

import java.util.List;

public interface ProductTypeDao {

    /**
     * 根据商品类型ID查询商品类型（验证商品类型Id输入是否合法）
     *
     * @param id
     * @return
     */
    ProductType findPTByIdAndIsParent(Integer id);

    /**
     * 分页查询
     * @param pageInfo  分页类
     * @return
     */
    List<ProductTypeVO> findProductTypeByPage(PageInfo pageInfo, ProductTypeVO productTypeVO);
    /**
     * 统计商品类型数量
     * @return
     */
    /**
     * 检查类型名是否存在
     * @param typename
     * @return
     */
    ProductType findTypeByTypename(String typename);

    /**
     * 统计在一二级目录下的总数量
     * @return
     */
    Integer countTotal();

    /**
     * 检查id是否存在,且id必须是一级目录id
     * @param id
     * @return
     */
    ProductType findTypeidByIdAndNotParent(Integer id);


    /**
     * 添加商品类型
     * @param productType
     * @return
     */
    Boolean insertProductType(ProductType productType);

    /**
     * 修改商品类型
     * @param typename
     * @param productType
     * @return
     */
    Boolean updateProductType(String typename,ProductType productType);

    /**
     * 删除商品类型
     * @param typename
     * @return
     */
    Boolean deleteProductType(String typename);

    /**
     * 检查商品类型下是否为空
     * @param typename
     * @return
     */
    Integer deleteProductTypeCheckForTypeid(String typename);

    /**
     * 检查商品类型1级目录下是否存在二级目录
     * @param typeid
     * @return
     */
    Boolean deleteProductTypeCheckForPra(Integer typeid);
}
