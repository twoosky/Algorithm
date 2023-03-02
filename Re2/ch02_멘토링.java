package Re2;

import java.util.Arrays;
import java.util.Scanner;

public class ch02_멘토링 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] arr = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        int result = 0;
        for(int i = 1; i <= n; i++) {  // 1 ~ 4번 학생 탐색
            boolean[] able = new boolean[n + 1];
            Arrays.fill(able, true);
            able[i] = false;
            for(int j = 0; j < m; j++) {  // 행
                for(int k = 0; k < n; k++) {  // 열
                    int student = arr[j][k];
                    if (student == i) {
                        break;
                    }
                    able[student] = false;  // i번 학생은 student 멘토 못함
                }
            }

            for(int k = 1; k < able.length; k++) {
                if (able[k]) {
                    result++;
                }
            }
        }
        System.out.print(result);
    }
}
