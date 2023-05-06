package 구현;

import java.util.Scanner;

public class BOJ_2563 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        boolean[][] board = new boolean[100][100];
        for(int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            for(int j = y; j < (y + 10); j++) {
                for(int k = x; k < (x + 10); k++) {
                    board[j][k] = true;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if (board[i][j]) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
