package 인프런.ch8;

import java.util.*;

class Point {
    int x;
    int y;
    int depth;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 토마토 {
    private static int[][] graph;
    private static int[][] days;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        graph = new int[m][n];
        days = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = in.nextInt();
            }
        }
        System.out.print(bfs(n, m));
    }

    private static int bfs(int n, int m) {
        Queue<Pos> q = new LinkedList<>();

        for(int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    q.add(new Pos(i, j));
                }
            }
        }

        // 안 익은 토마토가 없다면 0 반환
        if(q.isEmpty()) {
            return 0;
        }

        while(!q.isEmpty()) {
            Pos point = q.poll();

            for(int k = 0; k < 4; k++) {
                int _x = point.x + dx[k];
                int _y = point.y + dy[k];
                if (_x >= 0 && _x < m && _y >= 0 && _y < n && graph[_x][_y] == 0) {
                    days[_x][_y] = days[point.x][point.y] + 1;
                    graph[_x][_y] = 1;
                    q.add(new Pos(_x, _y));
                }
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {  // 안 익은 토마토가 있다면 -1 반환
                    return -1;
                }
                result = Math.max(result, days[i][j]);
            }
        }

        return result;
    }
}
