package com.itheima.chap01.demo7list;

import java.util.LinkedList;

public class ListDemo2 {
    public static void main(String[] args) {
        // 目标：用LinkedList做一个队列对象
        LinkedList<String> queue = new LinkedList<>();
        // 入队
        queue.addLast("赵敏");
        queue.addLast("西门吹雪");
        queue.addLast("陆小凤");
        queue.addLast("石观音");
        System.out.println(queue);

        // 出队
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue);

        System.out.println("----------------------------------");

        // 做一个栈
        LinkedList<String> stack = new LinkedList<>();
        // 压栈
        stack.push("第一颗子弹");
        stack.push("第二颗子弹");
        stack.push("第三颗子弹");
        stack.push("第四颗子弹");
        System.out.println(stack);

        // 弹栈
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
