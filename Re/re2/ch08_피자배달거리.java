package Re.re2;

import java.util.*;

public class ch08_피자배달거리 {
    private static List<int[]> pizza = new ArrayList<>();
    private static List<int[]> house = new ArrayList<>();
    private static int[][] pick;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = in.nextInt();
                if (num == 2) pizza.add(new int[] {i, j});
                if (num == 1) house.add(new int[] {i, j});
            }
        }
        pick = new int[m][2];
        dfs(0, 0, m);
        System.out.println(result);
    }

    private static void dfs(int idx, int depth, int m) {
        if (depth == m) {
            result = Math.min(result, calculateDistance());
            return;
        }

        for(; idx < pizza.size(); idx++) {
            int[] pos = pizza.get(idx);
            pick[depth] = pos.clone();
            dfs(idx + 1, depth + 1, m);
        }
    }

    private static int calculateDistance() {
        int sum = 0;
        for(int[] hPos : house) {
            int dis = Integer.MAX_VALUE;
            for(int[] pPos : pick) {
                int d = Math.abs(hPos[0] - pPos[0]) + Math.abs(hPos[1] - pPos[1]);
                dis = Math.min(dis, d);
            }
            sum += dis;
        }
        return sum;
    }
}
