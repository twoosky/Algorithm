package 인프런.ch8;

import java.util.*;

public class 미로탐색 {
    private static int[][] graph = new int[7][7];
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int result = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
                graph[i][j] = in.nextInt();
            }
        }

        graph[0][0] = 1;
        dfs(0, 0);
        System.out.print(result);
    }

    private static void dfs(int x, int y) {
        if (x == 6 && y == 6) {
            result++;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int _x = x + dx[i];
            int _y = y + dy[i];
            if(_x >= 0 && _x < 7 && _y >= 0 && _y < 7 && graph[_x][_y] == 0) {
                graph[_x][_y] = 1;
                dfs(_x, _y);
                graph[_x][_y] = 0;
            }
        }
    }
}

/*
시작점 visited[0][0] 방문 체크 까먹지 않기
 */