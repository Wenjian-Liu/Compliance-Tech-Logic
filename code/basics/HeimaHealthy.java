package com.itheima.healthy;

import java.text.DecimalFormat;
import java.util.Scanner;

public class HeimaHealthy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short height;
        while (true) {
            System.out.print("请输入身高（cm）：");
            height = scanner.nextShort();
            if (height >= 140 && height <= 220) {
                break;
            }
            System.out.println("输入的身高不符合要求，请输入140-220之间的值");
        }
        double weight;
        while (true) {
            System.out.print("请输入体重（kg）：");
            weight = scanner.nextDouble();
            if (weight >= 40 && weight <= 200) {
                break;
            }
            System.out.println("输入的体重不符合要求，请输入40-200之间的值");
        }
        byte age;
        while (true) {
            System.out.print("请输入年龄：");
            age = scanner.nextByte();
            if (age >= 18 && age <= 70) {
                break;
            }
            System.out.println("输入的年龄不符合要求，请输入18-70之间的值");
        }
        byte gender;
        while (true) {
            System.out.print("请输入性别（0:男/1:女）：");
            gender = scanner.nextByte();
            if (gender == 0 || gender == 1) {
                break;
            }
            System.out.println("输入的性别不符合要求，请输入0或1");
        }
        byte activityLevel;
        while (true) {
            System.out.print("请输入活动级别（0:久坐/1:轻度/2:中度/3:高度）：");
            activityLevel = scanner.nextByte();
            if (activityLevel >= 0 && activityLevel <= 3) {
                break;
            }
            System.out.println("输入的活动级别不符合要求，请输入0-3之间的值");
        }
        String activityLevelStr = switch (activityLevel) {
            case 0 -> "久坐";
            case 1 -> "轻度运动";
            case 2 -> "中度运动";
            default -> "高度运动";
        };
        //计算BMI，并判断体型，设定运动目标
        //计算BMI
        double bmi = calculateBmi(height, weight);
        //判断体型
        String bodyType = calculateBodyType(bmi);
        //设定运动目标
        String goal = setGoal(bodyType);

        //计算BMR、TDEE、每日热量
        //计算BMR
        double bmr = calculateBmr(gender, weight, height, age);

        //计算TDEE
        double tdee = calculateTdee(activityLevel, bmr);

        //计算每日摄入能量
        double dailyCalorie = calculateDailyCalories(goal, tdee);
        //计算每日摄入的营养素的质量
        double protein = calculateProtein(dailyCalorie);
        double fat = calculateFat(dailyCalorie);
        double carbohydrate = calculateCarb(dailyCalorie);
        // 打印结果
        printResult(bmi, bodyType, goal, bmr, dailyCalorie, tdee, protein, carbohydrate, fat);
    }

    private static double calculateBmi(short height, double weight) {
        double heightInMeters = height / 100.0;
        return weight / (heightInMeters * heightInMeters);
    }

    private static String calculateBodyType(double bmi) {
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

    private static String setGoal(String bodyType) {
        return switch (bodyType) {
            case "偏瘦" -> "增肌";
            case "超重", "肥胖" -> "减重";
            default -> "保持";
        };
    }

    private static double calculateBmr(byte gender, double weight, short height, byte age) {
        return gender == 0 ?
                88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age) :
                447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
    }

    private static double calculateTdee(byte activityLevel, double bmr) {
        double activityFactor = switch (activityLevel) {
            case 0 -> 1.2;
            case 1 -> 1.375;
            case 2 -> 1.55;
            default -> 1.725;
        };
        return bmr * activityFactor;
    }

    private static double calculateDailyCalories(String goal, double tdee) {
        return switch (goal) {
            case "增肌" -> tdee + 300;
            case "减重" -> tdee - 300;
            default -> tdee;
        };
    }

    private static double calculateProtein(double dailyCalorie) {
        final double PROTEIN_PERCENT = 0.3;
        final int PROTEIN_KCAL_PER_GRAM = 4;
        return dailyCalorie * PROTEIN_PERCENT / PROTEIN_KCAL_PER_GRAM;
    }

    private static double calculateFat(double dailyCalorie) {
        final double FAT_PERCENT = 0.2;
        final int FAT_KCAL_PER_GRAM = 9;
        return dailyCalorie * FAT_PERCENT / FAT_KCAL_PER_GRAM; //shift + F6
    }

    private static double calculateCarb(double dailyCalorie) {
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
