package com.itheima.datastructure.array;

import org.springframework.util.StopWatch;

/**
 * @author zpstart
 * @create 2025-04-26 13:51
 */
public class TwoDimensionArray {
    public static void ij(int[][] a, int rows, int columns) {
        long sum = 0L;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) { // 缓存行 一次64字节 高速缓存 空间局部性原理
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void ji(int[][] a, int rows, int columns) {
        long sum = 0L;
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int rows = 1_000_000;
        int columns = 14;
        int[][] a = new int[rows][columns];

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("ij");
        ij(a, rows, columns);
        stopWatch.stop();

        stopWatch.start("ji");
        ji(a, rows, columns);
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());


    }
}
