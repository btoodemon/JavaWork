package com.javasm.service;

import com.javasm.dao.ProductDao;
import com.javasm.dao.ProductTypeDao;
import com.javasm.dao.impl.ProductDaoImpl;
import com.javasm.dao.impl.ProductTypeDaoImpl;
import com.javasm.entity.Product;
import com.javasm.entity.ProductType;
import com.javasm.util.PageInfo;
import com.javasm.vo.ProductVO;

import java.util.List;
import java.util.Scanner;

public class ProductService {

    Scanner out = new Scanner(System.in);
    ProductDao productDao = new ProductDaoImpl();
    ProductTypeDao productTypeDao = new ProductTypeDaoImpl();

    public void startProductMenu() {
        while (true) {
            System.out.println("位置：商品管理");
            System.out.println("1.查看商品信息");
            System.out.println("2.添加商品信息");
            System.out.println("3.修改商品信息");
            System.out.println("4.删除商品信息");
            System.out.println("5.返回上一层(主菜单)");
            System.out.println("请选择：");
            String chose = out.next();
            switch (chose) {
                case "1":
                    showProduct();
                    break;
                case "2":
                    saveProduct();
                    break;
                case "3":
                    updProduct();
                    break;
                case "4":
                    deleteProduct();
                    break;
                case "5":
                    return;
            }
        }
    }

    /**
     * 查询商品信息
     */
    private void showProduct() {
        boolean flag = true;
        while (flag) {
            System.out.println("位置：商品管理 --> 查看商品");
            System.out.println("1.查询所有");
            System.out.println("2.条件查询");
            System.out.println("3.返回上一层(商品管理)");
            String chose = out.next();
            switch (chose) {
                case "1":
                    showAllProductByPage();
                    break;
                case "2":
                    showProductByCondition();
                    break;
                case "3":
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
     * 分页显示所有的商品
     */
    private void showAllProductByPage() {
        //  获取总条数
        Integer total = productDao.countTotal(null);
        //  计算分页信息
        PageInfo page = new PageInfo();
        page.setTotal(total);
        List<ProductVO> list = productDao.findProductByPageAndProduct(page, null);
        printProduct(list);
        Boolean flag = true;
        while (flag) {
            System.out.println("总页数：" + page.getTotalPage() + " \t 总条数：" + page.getTotal() + " \t 当前页：" + page.getPage());
            System.out.println("1.首页 \t 2.上一页 \t 3.下一页 \t 4.尾页 \t 5.返回上一层(查看商品)  ");
            String chose = out.next();
            switch (chose) {
                case "1":
                    // 给page赋值（当前页）
                    page.setPage(1);
                    list = productDao.findProductByPageAndProduct(page, null);
                    printProduct(list);
                    break;
                case "2":
                    if (page.hashUpPage()) {
                        list = productDao.findProductByPageAndProduct(page, null);
                        printProduct(list);
                    }
                    break;
                case "3":
                    if (page.hashNextPage()) {
                        list = productDao.findProductByPageAndProduct(page, null);
                        printProduct(list);
                    }
                    break;
                case "4":
                    // 给page赋值（当前页）
                    page.setPage(page.getTotalPage());
                    list = productDao.findProductByPageAndProduct(page, null);
                    printProduct(list);
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
     * 条件查询
     */
    private void showProductByCondition() {
        boolean flag = true;
        while (flag) {
            System.out.println("请选择查询方式：1.商品名称  2.商品类型  3.返回上一层（查询商品）");
            String chose = out.next();
            if (chose.equals("3")) {
                break;//  退出循环,结束条件查询
            }
            System.out.println("请选择查询条件：");
            String value = out.next();

            boolean flagNext = true;
            ProductVO productVO = new ProductVO();
            switch (chose) {
                case "1":
                    productVO.setPname(value);
                    break;
                case "2":
                    productVO.setTypename(value);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("输入有误，请重新输入");
                    flagNext = false;
                    break;
            }
            if (!flagNext) {
                continue;// 退出本次循环进入到下次循环
            }

            // 统计总条数
            Integer total = productDao.countTotal(productVO);
            PageInfo pageInfo = new PageInfo();
            pageInfo.setTotal(total);
            List<ProductVO> list = productDao.findProductByPageAndProduct(pageInfo, productVO);
            printProduct(list);

            Boolean flagNextPage = true;
            while (flagNextPage) {
                System.out.println("总页数：" + pageInfo.getTotalPage() + " \t 总条数：" + pageInfo.getTotal() + " \t 当前页：" + pageInfo.getPage());
                System.out.println("1.首页 \t 2.上一页 \t 3.下一页 \t 4.尾页 \t 5.返回上一层(查看商品)  ");
                String chosePage = out.next();
                switch (chosePage) {
                    case "1":
                        // 给page赋值（当前页）
                        pageInfo.setPage(1);
                        list = productDao.findProductByPageAndProduct(pageInfo, productVO);
                        printProduct(list);
                        break;
                    case "2":
                        if (pageInfo.hashUpPage()) {
                            list = productDao.findProductByPageAndProduct(pageInfo, productVO);
                            printProduct(list);
                        }
                        break;
                    case "3":
                        if (pageInfo.hashNextPage()) {
                            list = productDao.findProductByPageAndProduct(pageInfo, productVO);
                            printProduct(list);
                        }
                        break;
                    case "4":
                        // 给page赋值（当前页）
                        pageInfo.setPage(pageInfo.getTotalPage());
                        list = productDao.findProductByPageAndProduct(pageInfo, productVO);
                        printProduct(list);
                        break;
                    case "5":
                        flagNextPage = false;
                        break;
                    default:
                        System.out.println("输入有误，请重新输入!");
                        break;
                }
            }
        }
    }

    /**
     * 输出商品信息
     *
     * @param list
     */
    private void printProduct(List<ProductVO> list) {
        System.out.println("商品编号 \t\t 商品名称 \t\t 商品类型 \t\t 商品数量");
        list.forEach(product -> {
            System.out.println(product.getId() + " \t\t " + product.getPname() + " \t\t " + product.getTypename()+ " \t\t " +product.getNum());
        });
    }

    /**
     * 添加
     */
    private void saveProduct() {
        while (true) {
            System.out.println("位置：商品管理 --> 添加商品");
            // 1.用户输入信息
            // 1.1用户输入商品名称
            String pname = checkPname();
            // 1.2用户输入价格
            Double price = checkPrice();
            // 1.3商品数量
            Integer number = checkNumber();
            // 1.4商品折扣
            Integer disCount = checkDiscount();
            // 1.5商品类型Id(只能是二级的商品类型ID)
            Integer ptId = checkTypeId();

            Product product = new Product(pname, price, number, disCount, ptId);
            // 2.调用数据层方法，将数据插入到数据库表中
            boolean flag = productDao.insertProduct(product);

            // 3.提示操作结果
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
     * 验证商品名称是否合法,需要其不存在
     *
     * @return
     */
    private String checkPname() {
        String pname = "";
        while (true) {
            System.out.println("请输入商品名称：");
            pname = out.next();
            // 1.2验证商品名称是否存在
            Product product = productDao.findProductByPname(pname);
            if (product != null) {//  名称已存在
                System.out.println("商品名称已存在，请重新输入");
            } else {
                break;
            }
        }
        return pname;
    }

    /**
     * 验证商品名是否存在,需要其存在,提供给修改和删除方法
     *
     * @return
     */
    private String checkPnameExist() {
        String pname = "";
        while (true) {
            System.out.println("请输入商品名称：");
            pname = out.next();
            // 1.2验证商品名称是否存在
            Product product = productDao.findProductByPname(pname);
            if (product != null) {//  名称已存在
                break;
            } else {
                System.out.println("商品名称不存在，请重新输入");
            }
        }
        return pname;
    }

    /**
     * 验证商品商品价格是否合法
     *
     * @return
     */
    private Double checkPrice() {
        Double price = null;
        while (true) {
            System.out.println("请输入商品价格：");
            String priceStr = out.next();
            try {
                price = Double.parseDouble(priceStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入的价格格式有误，请重新输入！");
            }
        }
        return price;
    }

    /**
     * 验证商品库存数量是否合法
     *
     * @return
     */
    private Integer checkNumber() {
        Integer number = null;
        while (true) {
            System.out.println("请输入商品库存数量");
            String numberStr = out.next();
            try {
                number = Integer.parseInt(numberStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入的商品库存数量有误请重新输入");
            }
        }
        return number;
    }


    /**
     * 验证商品商品折扣是否合法
     *
     * @return
     */
    private Integer checkDiscount() {
        Integer discount = null;
        while (true) {
            System.out.println("请输入商品折扣(1-10)：");
            String priceStr = out.next();
            try {
                discount = Integer.parseInt(priceStr);
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入的商品折扣格式有误，请重新输入！");
            }
        }
        return discount;
    }

    /**
     * 检查用户输入的商品类型的是否合法
     *
     * @return
     */
    private Integer checkTypeId() {
        Integer typeId = null;
        while (true) {
            System.out.println("请输入商品类型ID");
            String numberStr = out.next();
            try {
                typeId = Integer.parseInt(numberStr);
            } catch (NumberFormatException e) {
                System.out.println("输入的商品类型ID有误请重新输入");
                continue;
            }

            // 验证商品类型ID是否符合要求（二级类型）
            ProductType pt = productTypeDao.findPTByIdAndIsParent(typeId);
            if (pt != null) {
                break;
            } else {
                System.out.println("输入的商品类型有误，请重新输入。。");
            }
        }
        return typeId;
    }

    /**
     * 检查用户输入的商品状态是否合法
     *
     * @return
     */
    private Integer checkState() {
        Integer state = null;
        while (true) {
            System.out.println("请输入商品状态(1-正常，2-下架，3-删除)");
            String stateStr = out.next();
            try {
                state = Integer.parseInt(stateStr);

            } catch (Exception e) {
                System.out.println("输入的商品状态标识有误请重新输入");
                continue;
            }

            if (state.equals(1) || state.equals(2) || state.equals(3)) {
                break;
            } else {
                System.out.println("输入的商品状态标识不在范围内(1-正常，2-下架，3-删除),请重新输入");
            }
        }
        return state;
    }

    /**
     * 修改商品
     */
    private void updProduct() {
        while (true) {
            System.out.println("位置: 商品管理 --> 修改商品");
            String pname = checkPnameExist();
            Product product = new Product();
            Boolean isConfirm = true;
            while (isConfirm) {
                System.out.println("请选择要修改的内容:");
                System.out.println("1.商品名");
                System.out.println("2.价格");
                System.out.println("3.数量");
                System.out.println("4.折扣");
                System.out.println("5.商品类型id");
                System.out.println("6.商品类型id");
                System.out.println("7.返回并确认修改");
                String chose = out.next();
                switch (chose) {
                    case "1":
                        String pnameCh = checkPname();
                        product.setPname(pnameCh);
                        break;
                    case "2":
                        Double price = checkPrice();
                        product.setPrice(price);
                        break;
                    case "3":
                        Integer number = checkNumber();
                        product.setNum(number);
                        break;
                    case "4":
                        Integer disCount = checkDiscount();
                        product.setDiscount(disCount);
                        break;
                    case "5":
                        Integer tpId = checkTypeId();
                        product.setTypeid(tpId);
                        break;
                    case "6":
                        Integer state = checkState();
                        product.setState(state);
                        break;
                    case "7":
                        isConfirm = false;
                        break;
                    default:
                        System.out.println("输入有误");
                }
            }
            boolean flag = productDao.updateProduct(pname, product);
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
     * 删除商品
     */
    private void deleteProduct() {
        while (true) {
            System.out.println("位置: 商品管理 --> 删除商品");
            String pname = checkPnameExist();
            System.out.println("确定删除" + pname + "?(q确定)");
            String makesuir = out.next();
            if ("q".equals(makesuir)) {
                boolean flag = productDao.deleteProduct(pname);
                if (flag) {
                    System.out.println("修改成功");
                } else {
                    System.out.println("修改失败");
                }
            }
            System.out.println("是否继续删除（Y|y继续）");
            String chose = out.next();
            if (!"y".equals(chose.toLowerCase())) {
                break;
            }
        }
    }
}
