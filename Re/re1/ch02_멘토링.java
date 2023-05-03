package Re.re1;

import java.util.*;

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
        // 학생 번호 (1 ~ 4)
        for(int i = 1; i < n+1; i++) {
            result += check(m, n, i, arr);
        }
        System.out.print(result);
    }

    private static int check(int m, int n, int me, int[][] arr) {
        boolean[] able = new boolean[n + 1];
        Arrays.fill(able, true);
        able[me] = false;

        // 1. 첫번째 for문: 행
        for(int i = 0; i < m; i++) {
            int k;
            // 2. 두번째 for문: 해당 학생의 등수 찾기 위함 k가 등수
            for (k = 0; k < n; k++) {
                if (arr[i][k] == me) {
                    break;
                }
            }
            // 3. 해당 학생 등수보다 앞에 있는 학생번호는 false
            for(int j = 0; j < k; j++) {
                able[arr[i][j]] = false;
            }
        }

        int result = 0;
        for(int i = 1; i < n+1; i++) {
            if (able[i]) {
                result++;
            }
        }
        return result;
    }
}
