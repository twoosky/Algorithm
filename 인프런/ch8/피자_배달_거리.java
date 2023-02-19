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
    private static boolean[][] visited;
    private static int n;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();
        board = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    result += bfs(i, j);
                }
            }
        }
        System.out.println(result);
    }

    private static int bfs(int x, int y) {
        int result = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Point point = q.poll();
            if (board[point.x][point.y] == 2) {
                return result;
            }
            for(int i = 0; i < 4; i++) {
                int _x = x + dx[i];
                int _y = y + dy[i];
                if (_x >= 0 && _x < n && _y >= 0 && _y < n && !visited[_x][_y]) {
                    visited[_x][_y] = true;
                }
            }
            result++;
        }
        return -1;
    }

    private static void dfs(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int _x = x + dx[i];
            int _y = y + dy[i];
        }
    }
}
