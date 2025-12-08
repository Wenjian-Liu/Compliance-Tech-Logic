package com.itheima.healthy;

import java.text.DecimalFormat;
import java.util.Scanner;

public class HeimaHealthy {
    public static void main(String[] args) {
        //录入用户基本信息
        short height = (short) readValue("身高", 140, 220);
        double weight = readValue("体重", 40, 200);
        byte age = (byte) readValue("年龄", 18, 70);
        byte gender = (byte) readValue("性别(0:男/1:女)", 0, 1);
        byte activityLevel = (byte) readValue("活动级别(0-久坐，1-轻度运动，2-中度运动，3-高度运动)", 0, 3);
        //计算BMI，并判断体型，设定运动目标
        double bmi = calculateBmi(height, weight);
        String bodyType = calculateBodyType(bmi);
        String goal = setGoal(bodyType);
        //计算BMR、TDEE、每日热量
        double bmr = calculateBmr(gender, weight, height, age);
        double tdee = calculateTdee(activityLevel, bmr);
        double dailyCalorie = calculateDailyCalories(goal, tdee);
        //计算每日摄入的营养素的质量
        double protein = calculateProtein(dailyCalorie);
        double fat = calculateFat(dailyCalorie);
        double carbohydrate = calculateCarb(dailyCalorie);
        // 打印结果
        printResult(bmi, bodyType, goal, bmr, dailyCalorie, tdee, protein, carbohydrate, fat);
    }

    public static double readValue(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print("请输入" + prompt + "：");
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("输入不符合要求，请输入" + min + "~" + max + "之间的值");
        }
        return value;
    }
    public static double calculateBmi(short height, double weight) {
        double heightInMeters = height / 100.0;
        return weight / (heightInMeters * heightInMeters);
    }

    public static String calculateBodyType(double bmi) {
        String bodyType = "";
        if (bmi < 18.5) {
            bodyType = "偏瘦";
        } else if (bmi >= 18.5 && bmi < 25) {
            bodyType = "正常";
        } else if (bmi >= 25 && bmi < 30) {
            bodyType = "超重";
        } else {
            bodyType = "肥胖";
        }
        return bodyType;
    }

    public static String setGoal(String bodyType) {
        return switch (bodyType) {
            case "偏瘦" -> "增肌";
            case "超重", "肥胖" -> "减重";
            default -> "保持";
        };
    }

    public static double calculateBmr(byte gender, double weight, short height, byte age) {
        return gender == 0 ?
                88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age) :
                447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
    }

    public static double calculateTdee(byte activityLevel, double bmr) {
        double activityFactor = switch (activityLevel) {
            case 0 -> 1.2;
            case 1 -> 1.375;
            case 2 -> 1.55;
            default -> 1.725;
        };
        return bmr * activityFactor;
    }

    public static double calculateDailyCalories(String goal, double tdee) {
        return switch (goal) {
            case "增肌" -> tdee + 300;
            case "减重" -> tdee - 300;
            default -> tdee;
        };
    }

    public static double calculateProtein(double dailyCalorie) {
        final double PROTEIN_PERCENT = 0.3;
        final int PROTEIN_KCAL_PER_GRAM = 4;
        return dailyCalorie * PROTEIN_PERCENT / PROTEIN_KCAL_PER_GRAM;
    }

    public static double calculateFat(double dailyCalorie) {
        final double FAT_PERCENT = 0.2;
        final int FAT_KCAL_PER_GRAM = 9;
        return dailyCalorie * FAT_PERCENT / FAT_KCAL_PER_GRAM; //shift + F6
    }

    public static double calculateCarb(double dailyCalorie) {
        final double CARB_PERCENT = 0.5;
        final int CARB_KCAL_PER_GRAM = 4;
        return dailyCalorie * CARB_PERCENT / CARB_KCAL_PER_GRAM;
    }

    public static void printResult(
           double bmi, String bodyType, String goal,
           double bmr, double dailyCalorie, double tdee,
           double protein, double carbohydrate, double fat){
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println("BMI指数：" + df.format(bmi) + "，体型：" + bodyType);
        System.out.println("建议您继续" + goal);
        System.out.println("您的每日基础代谢为" + (int) bmr + "大卡，结合运动后的总代谢" + (int) tdee + "大卡，建议您每天消耗" + (int) dailyCalorie + "大卡");
        System.out.println("建议您每天吃" + (int) protein + "克蛋白质，" + (int) carbohydrate + "克碳水化合物，" + (int) fat + "克脂肪");
        }
}
