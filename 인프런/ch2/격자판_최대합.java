package 인프런.ch2;

import java.util.*;

public class 격자판_최대합 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] input = new int[size][size];

        for(int i = 0; i < size; i ++) {
            for(int j = 0; j < size; j++) {
                input[i][j] = in.nextInt();
            }
        }

        int max = 0;
        int cross1 = 0;
        int cross2 = 0;
        for(int i = 0; i < size; i ++) {
            int row = 0;
            int col = 0;
            cross1 += input[i][i];
            cross2 += input[size - i - 1][i];
            for(int j = 0; j < size; j++) {
                row += input[i][j];
                col += input[j][i];
            }
            max = Math.max(max, col);
            max = Math.max(max, row);
        }
        int cross = Math.max(cross1, cross2);
        max = Math.max(max, cross);
        System.out.print(max);
    }
}
