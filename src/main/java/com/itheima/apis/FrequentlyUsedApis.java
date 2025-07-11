package com.itheima.apis;

import org.springframework.util.StopWatch;

/**
 * @Author: zpstart
 * @Date: 2025-07-10 22:15
 * @Description:
 */
public class FrequentlyUsedApis {
    public static void main(String[] args) {
//        IntStream.of(Arrays.copyOfRange(array, 0, size));

        int rows = 1000000;
        int columns = 14;
        int[][] a = new int[rows][columns];

        StopWatch sw = new StopWatch();
        sw.start("ij");
//        ij(a, rows, columns);
        sw.stop();
        sw.start("ji");
//        ji(a, rows, columns);
        sw.stop();
        System.out.println(sw.prettyPrint());
    }
}
