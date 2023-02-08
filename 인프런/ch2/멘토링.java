package 인프런.ch2;

import java.util.*;

public class 멘토링 {
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
        for(int i = 0; i < n; i++) {  // 멘토 번호(0~2)
            for(int j = 0; j < n; j++) {  // 멘티 번호(0~2)
                int count = 0;
                for(int k = 0; k < m; k++) {  // 시험
                    int mentoRank = 0, menteeRank = 0;
                    for(int s = 0; s < n; s++) {  // 등수(0~2)
                        if (arr[k][s] == i+1) mentoRank = s;
                        if (arr[k][s] == j+1) menteeRank = s;
                    }
                    if (mentoRank < menteeRank) {
                        count++;
                    }
                }
                if (count == m) {
                    result++;
                }
            }
        }
        System.out.print(result);
    }
}
