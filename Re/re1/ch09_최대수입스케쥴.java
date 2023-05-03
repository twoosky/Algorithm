package Re.re1;

import java.util.*;

public class ch09_최대수입스케쥴 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);

        Queue<int[]> pQ = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int day = arr[0][1];
        int result = 0;
        int idx = 0;

        while(day > 0) {
            for(; idx < n; idx++) {
                if (day > arr[idx][1]) {
                    break;
                }
                pQ.offer(arr[idx]);
            }

            if (pQ.isEmpty()) {
                day--;
                continue;
            }
            int[] seminar = pQ.poll();
            result += seminar[0];
            day--;
        }
        System.out.print(result);
    }
}
