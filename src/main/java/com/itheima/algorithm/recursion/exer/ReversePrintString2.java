package com.itheima.algorithm.recursion.exer;

/**
 * @author zpstart
 * @create 2025-04-27 22:13
 */
public class ReversePrintString2 {
    public static void main(String[] args) {
        String testStr = "abcdefghijklmn";
        reversePrintString(testStr);
        System.out.println("=============");
        reversePrintString2("abcdefghijklmn");
    }
    public static void reversePrintString(String str) {
        int length = str.length();
        printStr(str, length - 1);
    }
    /**
     * 法1：递的过程中打印，索引逐渐减小
     * @return void
     */
    public static void printStr(String str, int index) {
        if (index < 0) {
            return;
        }
        System.out.println(str.charAt(index));
        printStr(str, index - 1);
    }

    public static void reversePrintString2(String str) {
        int length = str.length();
        printStr2(str, 0);
    }

    /**
     * 法2：归的过程中打印，索引逐渐增大
     * @return void
     */
    public static void printStr2(String str, int index) {
        if (index == str.length()) {
            return;
        }
        printStr2(str, index + 1);
        System.out.println(str.charAt(index));
    }
}
