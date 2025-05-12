package com.itheima.datastructure.honor;

import java.util.Scanner;

/**
 * @author zpstart
 * @create 2023-08-30 10:16
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int recordNum = in.nextInt();
        int[][] inputTimeArray = new int[recordNum][];
        int i = 0;

        // 注意 hasNext 和 hasNextLine 的区别
        for (int j = 0; j < recordNum; j++) {
            int pageNum = in.nextInt();
            int[] pageTime = new int[pageNum];
            for (int k = 0; k < pageNum; k++) {
                pageTime[k] = in.nextInt();
            }
            inputTimeArray[j] = pageTime;
            System.out.println(judgeSatisfyTime(inputTimeArray[j]));
        }
    }

    private static int judgeSatisfyTime(int[] timeArrayNums) {
        int sum = 0;
        int page = 0;
        for (int i = 1; i < timeArrayNums.length; i++) {
            sum += timeArrayNums[i];
            if (sum > 60) {
                sum %= 60;
                page = 0;
            }
            page++;
            if (page > 4) {
                return 0;
            }
        }
        return 1;
    }
}
