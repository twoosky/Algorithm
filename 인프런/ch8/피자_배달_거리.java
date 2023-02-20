package 인프런.ch8;

import java.util.*;
//
//class Point {
//    int x;
//    int y;
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}

public class 피자_배달_거리 {
    private static int[][] board;
    private static Point[] pick;
    private static int n;
    private static int m;
    private static List<Point> house;
    private static List<Point> pizza;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        board = new int[n][n];
        pick = new Point[m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }

        house = new ArrayList<>();
        pizza = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    house.add(new Point(i, j));
                } else if (board[i][j] == 2) {
                    pizza.add(new Point(i, j));
                }
            }
        }

        combi(0, 0);
        System.out.println(result);
    }

    private static void combi(int depth, int start) {
        if (depth == m) {
            // result에 담긴 피자집들과 집 거리 계산
            int sum = 0;
            for (Point hPos : house) {
                // 해당 집의 피자 배달 거리 (가장 가까운 피자집과의 거리)
                int min = Integer.MAX_VALUE;
                for (Point pPos : pick) {
                    int distance = Math.abs(hPos.x - pPos.x) + Math.abs(hPos.y - pPos.y);
                    min = Math.min(min, distance);
                }
                sum += min;
            }

            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < pizza.size(); i++) {
            pick[depth] = pizza.get(i);
            combi(depth + 1, i + 1);
        }
    }
}
