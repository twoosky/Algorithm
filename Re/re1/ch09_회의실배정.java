package Re.re1;

import java.util.*;

public class ch09_회의실배정 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[][] arr = new Integer[n][n];

        for(int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int end = arr[0][1];
        int count = 1;

        for(int idx = 1; idx < n; idx++) {
            if (end <= arr[idx][0]) {
                count++;
                end = arr[idx][1];
            }
        }
        System.out.println(count);
    }
}
