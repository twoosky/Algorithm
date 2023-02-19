package 인프런.ch8;

import java.util.*;

public class 섬나라_아일랜드_DFS {
    private static int[][] graph;
    private static int n;
    private static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = in.nextInt();
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    graph[i][j] = 0;
                    dfs(i, j);
                    result++;
                }
            }
        }
        System.out.print(result);
    }

    private static void dfs(int x, int y) {
        for(int i = 0; i < 8; i++) {
            int _x = x + dx[i];
            int _y = y + dy[i];
            if (_x >= 0 && _x < n && _y >= 0 && _y < n && graph[_x][_y] == 1) {
                graph[_x][_y] = 0;
                dfs(_x, _y);
            }
        }
    }
}
