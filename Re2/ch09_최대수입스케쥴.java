package Re2;

import java.util.*;

public class ch09_최대수입스케쥴 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]) return o2[0] - o1[0];
            return o2[1] - o1[1];
        });

        Queue<Integer> pQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int day = arr[0][1];
        int idx = 0;
        int money = 0;

        while(day > 0) {
            for(; idx < arr.length; idx++) {
                if (arr[idx][1] < day) {
                    break;
                }
                pQ.offer(arr[idx][0]);
            }
            if (pQ.isEmpty()) {
                day--;
                continue;
            }
            money += pQ.poll();
            day--;
        }
        System.out.print(money);
    }
}
