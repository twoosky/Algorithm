package 인프런.ch10;

import java.util.*;

public class 가장_높은_탑_쌓기_DP {
    public static class Brick implements Comparable<Brick> {
        int area;
        int height;
        int weight;
        public Brick(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            return o.weight - this.weight;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Brick> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int area = in.nextInt();
            int height = in.nextInt();
            int weight = in.nextInt();
            list.add(new Brick(area, height, weight));
        }

        Collections.sort(list);
        int result = 0;
        int[] dp = new int[n];
        dp[0] = list.get(0).height;

        for(int i = 1; i < n; i++) {
            Brick brick = list.get(i);
            int max = brick.height;
            for(int j = i; j >= 0; j--) {
                Brick tmp = list.get(j);
                if (brick.area > tmp.area) {
                    dp[i] += dp[j];
                }
            }
            dp[i] = max;
            result = Math.max(result,dp[i]);
        }

        System.out.println(result);
    }
}
