package com.itheima.chap01;

public class ToStringDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Chris",18);

        //2017700924
        System.out.println(p1.hashCode());
        //com.itheima.chap01.Person@7843ac3c
        System.out.println(p1);
    }
}
