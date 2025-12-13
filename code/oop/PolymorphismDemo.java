package com.itheima.chap03;

public class PolymorphismDemo {
    public static void main(String[] args) {
        //向上转型
        Product p = new PhysicalProduct("华为Mate70",7299.00,672.00);
        DigitalProduct d = new DigitalProduct("Appstore充值卡",99.00,"12345678");

        createOrder(p);
        createOrder(d);
    }

    public static void createOrder(Product product) {
        //向下转型，之前要做类型检查
        if (product instanceof PhysicalProduct) {
            PhysicalProduct p = (PhysicalProduct) product;
            p.setWeight(586.00);
        }
        //展示商品信息
        System.out.println(product.displayInfo());
        //确认订单
        System.out.println("订单已确认！");
    }
}
