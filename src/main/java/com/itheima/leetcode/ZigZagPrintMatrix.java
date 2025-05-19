package com.itheima.leetcode;

/**
 * @author zpstart
 * @create 2025-05-19 10:43
 */
public class ZigZagPrintMatrix {
    public static void printMatrixZigZag(int[][] matrix) {
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;

        boolean isFromUp = false; // 是不是从右上往左下打印
        while (aR != endR + 1) {
            // 告诉斜线的两端和方向 A先向右走
            printLevel(matrix, aR, aC, bR, bC, isFromUp);
            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1; // 哪个先动要写到后面
            bC = bR == endR ? bC + 1 : bC;
            bR = bR == endR ? endR : bR + 1;
            isFromUp = !isFromUp;
            System.out.println();
        }
    }

    private static void printLevel(int[][] m, int aR, int aC, int bR, int bC,
                                   boolean isFromUp) {
        if (isFromUp) {
            while (aR != bR + 1) {
                System.out.print(m[aR++][aC--] + " ");
            }
        } else {
            while (bR != aR - 1) {
                System.out.print(m[bR--][bC++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrixZigZag(matrix);
    }
}
