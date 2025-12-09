package com.itheima.chapter08;

public class ArrayDemo {
    public static void main(String[] args) {
        //String[] foods = new String[5];
        //String[] foods = new String[] {"土豆","玉米","米饭","面条","红薯"};
        String[] foods = {"土豆","玉米","米饭","面条","红薯"};

        System.out.println("foods[0]：" + foods[0]);
        System.out.println("foods[1]：" + foods[1]);
        System.out.println("foods[2]：" + foods[2]);
        System.out.println("foods[3]：" + foods[3]);
        System.out.println("foods[4]：" + foods[4]);

        foods[4] = "紫薯";
        System.out.println("foods[4]：" + foods[4]);
    }
}
