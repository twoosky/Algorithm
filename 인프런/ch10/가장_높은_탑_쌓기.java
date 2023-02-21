package 인프런.ch10;

import java.util.*;

public class 가장_높은_탑_쌓기 {
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
            return o.area - this.area;
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

        // 넓이를 기준으로 내림차순 정렬
        Collections.sort(list);

        int[] dp = new int[n];
        dp[0] = list.get(0).height;
        int result = dp[0];

        for(int i = 1; i < n; i++) {
            Brick brick = list.get(i);
            int max = 0;
            for(int j = i; j >= 0; j--) {
                Brick tmp = list.get(j);
                if (brick.weight < tmp.weight && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + brick.height;
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}

/*
입력
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2

넓이 오름차순으로 정렬
25 3 4
16 2 5
9 2 3
4 4 6
1 5 2
 */

/*
dp 배열은 해당 벽돌에서 가장 높이 쌓을 수 있는 탑의 높이 저장
dp 배열 업데이트 과정

현재 벽돌
16 2 5 : { 3, 2, 0, 0, 0 }
9 2 3  : { 3, 2, 5, 0, 0 }
4 4 6  : { 3, 2, 5, 4, 0 }
1 5 2  : { 3, 2, 5, 4, 10 }
 */
