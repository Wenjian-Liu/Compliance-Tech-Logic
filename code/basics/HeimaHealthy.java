package com.itheima.healthy;

import java.text.DecimalFormat;
import java.util.Scanner;

public class HeimaHealthy {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        short height;
        while (true) {
            System.out.print("请输入身高（cm）：");
            height = scanner.nextShort();
            if (height >= 140 && height <= 220){
                break;
            }
            System.out.println("输入的身高不符合要求，请输入140-220之间的值");
            }
        double weight;
        while (true) {
            System.out.print("请输入体重（kg）：");
            weight = scanner.nextDouble();
            if (weight >= 40 && weight <= 200){
                break;
            }
            System.out.println("输入的体重不符合要求，请输入40-200之间的值");
        }
        byte age;
        while (true) {
            System.out.print("请输入年龄：");
            age = scanner.nextByte();
            if (age >= 18 && age <= 70){
                break;
            }
            System.out.println("输入的年龄不符合要求，请输入18-70之间的值");
        }
        byte gender;
        while (true) {
            System.out.print("请输入性别（0:男/1:女）：");
            gender = scanner.nextByte();
            if (gender == 0 || gender == 1){
                break;
            }
            System.out.println("输入的性别不符合要求，请输入0或1");
        }
        byte activityLevel;
        while (true) {
            System.out.print("请输入活动级别（0:久坐/1:轻度/2:中度/3:高度）：");
            activityLevel = scanner.nextByte();
            if (activityLevel >= 0 && activityLevel <= 3){
                break;
            }
            System.out.println("输入的活动级别不符合要求，请输入0-3之间的值");
        }
        double heightInMeters = height / 100.0;
        double bmi = weight / (heightInMeters * heightInMeters);
        String bodyType;
        if (bmi < 18.5) {
            bodyType = "偏瘦";
        }
        else if (bmi >= 18.5 && bmi < 25) {
            bodyType = "正常";
        }
        else if (bmi >= 25 && bmi < 30) {
            bodyType = "超重";
        }
        else {
            bodyType = "肥胖";
        }
        String goal = switch (bodyType) {
            case "偏瘦" -> "增肌";
            case "超重", "肥胖" -> "减重";
            default -> "保持";
        };
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println("BMI指数：" + df.format(bmi) + "，体型：" + bodyType);
        System.out.println("建议您继续" + goal);
        double bmr =  gender == 0?
                88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age) :
                447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        double activityFactor =  switch (activityLevel) {
            case 0 -> 1.2;
            case 1 -> 1.375;
            case 2 -> 1.55;
            default -> 1.725;
        };
        double tdee = bmr * activityFactor;
        double dailyCalorie = switch (goal) {
            case "增肌" -> tdee + 300;
            case "减重" -> tdee - 300;
            default -> tdee;
        };
        double protein = dailyCalorie * 0.3 / 4;
        double fat = dailyCalorie * 0.2 / 9;
        double carbohydrate = dailyCalorie * 0.5 / 4;

        System.out.println("用户信息如下：");
        System.out.println("身高：" + height + "cm");
        System.out.println("体重：" + weight + "kg");
        System.out.println("年龄：" + age + "岁");
        String genderStr = (gender == 0) ? "男" : "女";
        System.out.println("性别：" + genderStr);
        String activityLevelStr = switch (activityLevel) {
            case 0 -> "久坐";
            case 1 -> "轻度运动";
            case 2 -> "中度运动";
            default -> "高度运动";
        };
        System.out.println("活动级别：" + activityLevelStr);
        System.out.println("您的每日基础代谢为" + (int) bmr + "大卡，结合运动后的总代谢" + (int) tdee + "大卡，建议您每天消耗" + (int) dailyCalorie + "大卡");
        System.out.println("建议您每天吃" + (int) protein + "克蛋白质，" + (int) carbohydrate + "克碳水化合物，" + (int) fat + "克脂肪");
        }
}
