package com.itheima.leetcode;

/**
 * @author zpstart
 * @create 2025-05-19 11:19
 */
public class PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][] matrix) {
        int aR = 0;
        int aC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (aR <= dR && aC <= dC) {
            printEdge(matrix, aR++, aC++, dR--, dC--);
        }
    }

    public static void printEdge(int[][] matrix, int aR, int aC, int dR, int dC) {
        if (aR == dR) {
            for (int i = aC; i <= dC; i++) {
                System.out.print(matrix[aR][i] + " ");
            }
        } else if (aC == dC) {
            for (int i = aR; i <= dR; i++) {
                System.out.print(matrix[i][aC] + " ");
            }
        } else {
            int curC = aC;
            int curR = aR;
            while (curC != dC) {
                System.out.print(matrix[aR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.print(matrix[curR][aC] + " ");
                curR++;
            }
            while (curC != aC) {
                System.out.print(matrix[dR][curC] + " ");
                curC--;
            }
            while (curR != aR) {
                System.out.print(matrix[curR][aC] + " ");
                curR--;
            }
        }
    }
}
