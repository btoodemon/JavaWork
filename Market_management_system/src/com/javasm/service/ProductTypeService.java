package com.javasm.service;

import com.javasm.dao.ProductDao;
import com.javasm.dao.ProductTypeDao;
import com.javasm.dao.impl.ProductDaoImpl;
import com.javasm.dao.impl.ProductTypeDaoImpl;
import com.javasm.entity.ProductType;
import com.javasm.util.PageInfo;
import com.javasm.vo.ProductTypeVO;

import java.util.List;
import java.util.Scanner;

public class ProductTypeService {
    Scanner out = new Scanner(System.in);
    ProductDao productDao = new ProductDaoImpl();
    ProductTypeDao productTypeDao = new ProductTypeDaoImpl();

    public void startProductMenu() {
        while (true) {
            System.out.println("位置：商品类型管理");
            System.out.println("1.查看商品类型");
            System.out.println("2.添加商品类型");
            System.out.println("3.修改商品类型");
            System.out.println("4.删除商品类型");
            System.out.println("5.返回上一层(主菜单)");
            System.out.println("请选择：");
            String chose = out.next();
            switch (chose) {
                case "1":
                    showProductType();
                    break;
                case "2":
                    saveProductTypt();
                    break;
                case "3":
                    updProductTypt();
                    break;
                case "4":
                    deleteProductType();
                    break;
                case "5":
                    return;
            }
        }
    }

    /**
     * 查看商品类型
     */
    private void showProductType() {
        boolean flag = true;
        while (flag) {
            System.out.println("位置：商品类型管理 --> 查看商品类型");
            System.out.println("1.查询所有商品类型");
            System.out.println("2.返回上一层(商品类型管理)");
            String chose = out.next();
            switch (chose) {
                case "1":
                    showAllProductTypeByPage();
                    break;
                case "2":
                    return;
                default:
                    System.out.println("输入有误，请重新输入！");
                    break;
            }
            System.out.println("是否继续查询（y|Y继续）？");
            String resultFlag = out.next();
            if (!"y".equals(resultFlag.toLowerCase())) {// 退出查询商品
                flag = false;
            }
        }
    }

    /**
     * 打印所有商品类别
     */
    private void showAllProductTypeByPage() {
        Integer total = productTypeDao.countTotal();
        PageInfo page = new PageInfo();
        page.setTotal(total);
        List<ProductTypeVO> list = productTypeDao.findProductTypeByPage(page, null);
        printProductType(list);
        Boolean flag = true;
        while (flag) {
            System.out.println("总页数：" + page.getTotalPage() + " \t 总条数：" + page.getTotal() + " \t 当前页：" + page.getPage());
            System.out.println("1.首页 \t 2.上一页 \t 3.下一页 \t 4.尾页 \t 5.返回上一层(查看商品)  ");
            String chose = out.next();
            switch (chose) {
                case "1":
                    // 给page赋值（当前页）
                    page.setPage(1);
                    list = productTypeDao.findProductTypeByPage(page, null);
                    printProductType(list);
                    break;
                case "2":
                    if (page.hashUpPage()) {
                        list = productTypeDao.findProductTypeByPage(page, null);
                        printProductType(list);
                    }
                    break;
                case "3":
                    if (page.hashNextPage()) {
                        list = productTypeDao.findProductTypeByPage(page, null);
                        printProductType(list);
                    }
                    break;
                case "4":
                    // 给page赋值（当前页）
                    page.setPage(page.getTotalPage());
                    list = productTypeDao.findProductTypeByPage(page, null);
                    printProductType(list);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("输入有误，请重新输入!");
                    break;
            }
        }
    }

    /**
     * 打印方法
     * @param list
     */
    private void printProductType(List<ProductTypeVO> list) {
        System.out.println("id\t\t 一级目录 \t\t id \t\t 二级目录");
        list.forEach(productTypeVO -> {
            System.out.println(productTypeVO.getId() + " \t\t " + productTypeVO.getTypename() + " \t\t " + productTypeVO.getIdpra() + " \t\t " + productTypeVO.getTypenamepra());
        });
    }

    /**
     * 添加商品类型
     */
    private void saveProductTypt() {
        while (true) {
            System.out.println("位置：商品类型管理 --> 添加商品类型");
            String typename = checkTypeName();
            Integer parentId = null;
            Integer flagParent = null;
            while (true) {
                System.out.println("请选择创建的类型级别: 1.一级目录 2.二级目录");
                Integer i = out.nextInt();
                if (i.equals(1)) {

                    parentId = 0;//checkTypeId();
                    flagParent = 1;
                    break;
                } else if (i.equals(2)) {

                    parentId = checkTypeIdPra();
                    flagParent = 0;
                    break;
                } else {
                    System.out.println("输入错误,请重新选择 1.一级目录 2.二级目录");
                }
            }
            ProductType productType = new ProductType(parentId, typename, flagParent, null, null);
            boolean flag = productTypeDao.insertProductType(productType);
            if (flag) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
            System.out.println("是否继续添加（Y|y继续）");
            String chose = out.next();
            if (!"y".equals(chose.toLowerCase())) {
                break;
            }
        }


    }

    /**
     * 检查输入的一级商品类别ID是否合法
     * @return
     */
    private Integer checkTypeId() {
        Integer typeId = null;
        while (true) {
            System.out.println("请输入所属一级商品类型id");
            String typeIdStr = out.next();
            try {
                typeId = Integer.parseInt(typeIdStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入的商品类型id有误请重新输入");
            }
        }
        return typeId;
    }

    /**
     * 定义为二级商品类别,输入并判断其父一级商品类别是否存在
     * @return
     */
    private Integer checkTypeIdPra() {
        Integer typeId = null;
        while (true) {
            System.out.println("请输入所属一级商品类型id");
            String typeIdStr = out.next();
            try {
                typeId = Integer.parseInt(typeIdStr);
            } catch (NumberFormatException e) {
                System.out.println("输入的商品类型id有误请重新输入");
            }

            ProductType productType = productTypeDao.findTypeidByIdAndNotParent(typeId);
            if (productType != null) {
                break;
            } else {
                System.out.println("输入的一级id未找到,请重新输入");
            }
        }
        return typeId;
    }

    /**
     * 检查商品类型名是否合法,需要其不存在
     *
     * @return
     */
    private String checkTypeName() {
        String typename = "";
        while (true) {
            System.out.println("请输入商品类型名称: ");
            typename = out.next();
            ProductType productType = productTypeDao.findTypeByTypename(typename);
            if (productType != null) {
                System.out.println("商品类型已存在,请重新输入");
            } else {
                break;
            }
        }
        return typename;
    }

    /**
     * 检查商品类型名是否存在,需要其存在,提供给修改和删除方法
     *
     * @return
     */
    private String checkTypeNameExist() {
        String typename = "";
        while (true) {
            System.out.println("请输入商品类型名称: ");
            typename = out.next();
            ProductType productType = productTypeDao.findTypeByTypename(typename);
            if (productType != null) {
                break;
            } else {
                System.out.println("商品类型不存在,请重新输入");
            }
        }
        return typename;
    }

    /**
     * 修改商品类别
     */
    private void updProductTypt() {
        while (true) {
            System.out.println("位置: 商品类别管理 --> 修改商品类别");
            String typename = checkTypeNameExist();
            ProductType productType = new ProductType();
            Boolean isConfirm = true;
            while (isConfirm) {
                System.out.println("请输入要修改的内容");
                System.out.println("1.商品类别名");
                System.out.println("2.修改商品类别父id");
                System.out.println("3.返回并确认修改");
                String chose = out.next();
                switch (chose) {
                    case "1":
                        String typenameCh = checkTypeName();
                        productType.setTypename(typenameCh);
                        break;
                    case "2":
                        Integer typeId = checkTypeIdPra();
                        productType.setParentId(typeId);
                        break;
                    case "3":
                        isConfirm = false;
                        break;
                    default:
                        System.out.println("输入有误");
                }
            }
            boolean flag = productTypeDao.updateProductType(typename, productType);
            if (flag) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
            System.out.println("是否继续修改（Y|y继续）");
            String chose = out.next();
            if (!"y".equals(chose.toLowerCase())) {
                break;
            }

        }
    }

    /**
     * 删除商品类别
     */
    private void deleteProductType() {
        while (true) {
            System.out.println("位置: 商品类别管理 --> 删除商品类别");
            String typename = checkTypeNameExist();
            //用typename查找到对应的typeid
            Integer typeid = productTypeDao.deleteProductTypeCheckForTypeid(typename);

            //检查typeid下是否存在product
            Boolean deletecheck = productDao.productCheckByType(typeid);
            if (!deletecheck) {
                Boolean forPra = productTypeDao.deleteProductTypeCheckForPra(typeid);
                if (forPra){
                    System.out.println("该类别下依然有类别存在,禁止删除");
                }else {
                    System.out.println("确定删除" + typename + "?(q确定)");
                    String makesuir = out.next();
                    if ("q".equals(makesuir)) {
                        boolean flag = productTypeDao.deleteProductType(typename);
                        if (flag) {
                            System.out.println("修改成功");
                        } else {
                            System.out.println("修改失败");
                        }
                    }
                }

            }else {
                System.out.println("类别下依然有商品存在,禁止删除");
            }
            System.out.println("是否继续删除（Y|y继续）");
            String chose = out.next();
            if (!"y".equals(chose.toLowerCase())) {
                break;
            }
        }
    }

}
