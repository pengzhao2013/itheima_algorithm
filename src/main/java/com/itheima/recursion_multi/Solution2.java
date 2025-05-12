package com.itheima.recursion_multi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zpstart
 * @create 2023-08-22 19:28
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int num = 0;
//        while (in.hasNextInt()) {
//            num = in.nextInt();
//        }
        int num =11;
        String strNum = String.valueOf(num);
        boolean flag = false;
        for (int i = 0; i < strNum.length() - 1; i++) {
            Integer leftMultiply = 1;
            Integer rightMultiply = 1;
            for (int j = 0; j <= i; j++) {
                leftMultiply *= Integer.parseInt(strNum.charAt(j) + "");
            }
            for (int j = strNum.length() - 1; j > i; j--) {
                rightMultiply *= Integer.parseInt(strNum.charAt(j) + "");
            }
            if (leftMultiply == rightMultiply) {
                flag = true;
                System.out.println("YES");
            }
        }
        if (!flag) {
            System.out.println("NO");
        }
    }
}
