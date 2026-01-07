package com.itheima.demo1hashset;

import java.util.HashSet;
import java.util.Set;

public class SetDemo2 {
    public static void main(String[] args) {
        // 目标：掌握Hashset集合去重操作
        Student s1 = new Student("小王", 18, "北京", "110");
        Student s2 = new Student("张三", 19, "上海", "152346");
        Student s3 = new Student("小王", 18, "北京", "110");
        Student s4 = new Student("张三", 19, "上海", "152346");

        Set<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);

        System.out.println(set);


    }
}
