package 인프런.ch10;

import java.util.*;

class Q {
    int score;
    int time;
    public Q(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class 최대점수_구하기 {
    private static int n;
    private static int m;
    private static List<Q> arr;
    private static int result = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Q(in.nextInt(), in.nextInt()));
        }

        System.out.println(knapsack());
    }

    private static int knapsack() {
        int[] dp = new int[m + 1];
        for(int i = 0; i < n; i++) {
            Q q = arr.get(i);
            for(int j = m; j >= q.time; j--) {
                int tmp = dp[j - q.time] + q.score;
                if (dp[j] < tmp) {
                    dp[j] = tmp;
                }
            }
        }
        return dp[m];
    }
}
