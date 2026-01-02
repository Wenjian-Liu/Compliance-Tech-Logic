package com.itheima.chap01.gpt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListRemovePractice {
    public static void main(String[] args) {
        // 练习：
// 1. 倒序 for 删除（避免跳过元素）
// 2. 使用 Iterator.remove() 解决并发修改异常
// 3. 对 Integer 和 String 两种类型分别验证

        // 1) int：倒序for删奇数
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(list);

        for (int i = list.size() - 1; i >= 0; i--) {
            int num = list.get(i);
            if(num % 2 == 1) {
                list.remove(i);
            }
        }
        System.out.println(list);
        System.out.println("===================");

        // 2) int：迭代器删奇数
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        list2.add(9);
        list2.add(10);
        System.out.println(list2);

        Iterator<Integer> it = list2.iterator();
        while(it.hasNext()) {
            int i = it.next();
            if(i % 2 == 1) {
                it.remove();
            }
        }
        System.out.println(list2);
        System.out.println("===================");

        // 3) String：倒序for删长度小于3的字符串
        List<String> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("ab");
        list3.add("abc");
        list3.add("abcd");
        list3.add("x");
        list3.add("xy");
        list3.add("xyz");
        System.out.println(list3);

        for (int i = list3.size() - 1; i >=0; i--) {
            String s = list3.get(i);
            if(s.length() < 3) {
                list3.remove(i);
            }
        }
        System.out.println(list3);
        System.out.println("===================");

        // 4) String：迭代器删长度小于3的字符串
        List<String> list4 = new ArrayList<>();
        list4.add("a");
        list4.add("ab");
        list4.add("abc");
        list4.add("abcd");
        list4.add("x");
        list4.add("xy");
        list4.add("xyz");
        System.out.println(list4);

        Iterator<String> it2 = list4.iterator();
        while(it2.hasNext()) {
            String s2 = it2.next();
            if(s2.length() < 3) {
                it2.remove();
            }
        }
        System.out.println(list4);
    }
}
