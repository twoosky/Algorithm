package Re2;

import java.util.*;

public class ch09_회의실배정 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int end = arr[0][1];
        int count = 1;
        for(int i = 1; i < arr.length; i++) {
            if (arr[i][0] >= end) {
                end = arr[i][1];
                count++;
            }
        }
        System.out.print(count);
    }
}
