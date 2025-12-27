// Note: Input validation via instanceof is incorrect for primitives;
// proper handling will be revisited after learning exception handling.
package com.itheima.ai;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int num1 = scanner.nextInt();
        System.out.println("你输入的整数是：" + num1);
        System.out.print("请输入一个小数：");
        double num2 = scanner.nextDouble();
        System.out.println("你输入的小数是：" + num2);
    }
}
