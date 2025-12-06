package Leetcode;

public class LC_013_RomanToInteger {
    //将罗马字符转换成数字
    public static int valueOf(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    public static int romanToInt(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int current = valueOf(s.charAt(i));
            //如果不是最后一个字符，就和下一个比较
            if (i < s.length() - 1) {
                int next = valueOf(s.charAt(i + 1));
                if (current < next) {
                    total -= current;
                }
                else {
                    total += current;
                }
            } else {
                total += current;
            }
        }
        return total;
    }
    //测试
    public static void main(String[] args) {
        System.out.println(romanToInt("III")); //3
        System.out.println(romanToInt("LVIII")); //58
        System.out.println(romanToInt("MCMXCIV")); //1994
    }
}
