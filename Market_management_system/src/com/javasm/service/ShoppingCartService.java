package com.javasm.service;

import com.javasm.entity.Product;
import com.javasm.entity.ShoppingCart;
import com.javasm.entity.UserManage;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCartService {

    /**
     * 单例模式开始
     **/
    // 购物车，Integer：商品id  ShoppingCart：商品购物详情
    private static Map<Integer, ShoppingCart> cartMap;
    private static Double catMoney = 0.0;
    private static UserManage userManage = new UserManage();
    private static Integer paytype = 0;

    public static Map<Integer, ShoppingCart> getCartMap() {
        if (cartMap == null) {
            cartMap = new HashMap<>();
        }
        return cartMap;
    }
    /**
     * 单例模式结束
     **/


    /**
     * 添加商品到购物车中
     *
     * @param product 购买的商品
     * @param num     购买的数量
     */
    public void saveProdctToCart(Product product, Integer num) {
        // 1.判断当前的商品在购物车中是否存在
        Boolean idChek = cartMap.containsKey(product.getId());
        // 2.如果购物车中有当前的商品，修改购买数量
        // 3.如果购物车中没有当前的商品，将商品添加到购物车中
        if (idChek) {
            ShoppingCart shoppingCart = cartMap.get(product.getId());
            shoppingCart.setCartNumber(num + shoppingCart.getCartNumber());
            shoppingCart.setCartPrice(shoppingCart.getCartNumber() * product.getPrice() * product.getDiscount() / 10);
            cartMap.replace(product.getId(), shoppingCart);
        } else {
            ShoppingCart shoppingCart = new ShoppingCart(num, num * product.getPrice() * product.getDiscount() / 10, product);
            cartMap.put(product.getId(), shoppingCart);
        }
        System.out.println("商品成功添加到购物车");
    }

    /***
     * 修改商品购买数量
     * @param productId 商品的编号
     * @param number 购买数量
     */
    public void updateProductToCart(Integer productId, Integer number) {
        // 判断当前的商品ID在购物车中是否存在，如果存在，就修改当前商品的购买数量
        boolean containsKey = cartMap.containsKey(productId);
        if (containsKey) {
            ShoppingCart shoppingCart = cartMap.get(productId);
            shoppingCart.setCartNumber(number);
            shoppingCart.setCartPrice(number * shoppingCart.getProduct().getPrice() * shoppingCart.getProduct().getDiscount() / 10);
            cartMap.replace(productId, shoppingCart);
            catMoney = 0.0;
            cartMap.forEach((k, v) -> {
                catMoney += v.getCartPrice();
            });
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败,商品ID不存在");
        }
    }

    /**
     * 删除购物车中的商品
     *
     * @param productId
     */
    public void deleteProductToCart(Integer productId) {
        // 删除集合中的元素
        boolean containsKey = cartMap.containsKey(productId);
        if (containsKey) {
            cartMap.remove(productId);
            catMoney = 0.0;
            cartMap.forEach((k, v) -> {
                catMoney += v.getCartPrice();
            });
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败,商品ID不存在");
        }
    }

    /**
     * 显示购物车中所有的商品
     */
    public void showCartProduct() {
        System.out.println("订单列表 \t 商品名 \t\t 商品单价 \t\t 数量 \t\t 价格");
        catMoney = 0.0;

        cartMap.forEach((k, v) -> {
            System.out.println(k + "\t\t" + v.getProduct().getPname() + "\t\t" + v.getProduct().getPrice() + "\t\t" + v.getCartNumber() + "\t\t" + v.getCartPrice());
            catMoney += v.getCartPrice();
        });
        System.out.println("总金额为" + catMoney);
    }

    /**
     * 清空购物车中的商品
     */
    public void clear() {
        // 删除集合中所有元素
        cartMap.clear();//清空购物车map
        catMoney=0.0;//初始化总金额
        paytype=0;//初始化默认支付方式
        userManage=new UserManage();//初始化支付会员
    }

    /**
     *
     * @return
     */
    public Double getCatMoney() {
        return catMoney;
    }

    public UserManage getUserManage() {
        return userManage;
    }

    public void setUserManage(UserManage userManage) {
        ShoppingCartService.userManage = userManage;
    }

    public Integer getPaytype() {
        return paytype;
    }

    public void setPaytype(Integer paytype) {
        ShoppingCartService.paytype = paytype;
    }
}
