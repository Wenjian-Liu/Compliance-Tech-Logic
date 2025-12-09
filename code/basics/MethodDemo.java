package com.itheima.chapter07;

public class MethodDemo {
    public static void main(String[] args) {
        int max = getMax(10,20);
        System.out.println("max = " + max);

        max = getMax(50,20);
        System.out.println("max = " + max);

        sayHello("小刘");
    }

    //定义一个求两个int数之间最大数的方法
    public static int getMax(int a, int b) {
        return a > b ? a : b;
    }

    //接受一个人名，打印hello + 人名
    public static void sayHello(String name) {
        System.out.println("hello, " + name);
    }
}
