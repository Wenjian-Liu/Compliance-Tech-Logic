package com.itheima.chap02;

public class Employee {
    private int baseSalary;
    private int bonus;

    /*
    构造方法：
    1.不需要写返回值
    2.方法名与类名完全一致
     */
    public Employee(int baseSalary, int bonus) {
        setBaseSalary(baseSalary);
        setBonus(bonus);
    }

    public int calculateSalary(char grade) {
        //计算奖金系数
        double rate = calculateRate(grade);
        //计算薪资
        return baseSalary + (int)(bonus * rate);
    }

    private double calculateRate(char grade) {
        return switch (grade) {
            case 'A' -> 1.0;
            case 'B' -> 0.8;
            case 'C' -> 0.6;
            case 'D' -> 0.4;
            default -> 0;
        };
    }

    private void setBaseSalary(int baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("BaseSalary cannot be negative.");
        }
        this.baseSalary = baseSalary;
    }
    private int getBaseSalary() {
        return baseSalary;
    }
    private void setBonus(int bonus) {
        if (bonus < 0) {
            throw new IllegalArgumentException("Bonus cannot be negative.");
        }
        this.bonus = bonus;
    }
}
