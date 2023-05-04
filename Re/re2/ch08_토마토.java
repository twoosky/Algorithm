package Re.re2;

import java.util.*;

public class ch08_토마토 {
    private static int[][] arr;
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        arr = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        int day = bfs(n, m);
        if (check(n, m)) {
            System.out.println(day - 1);
        } else {
            System.out.println(-1);
        }
    }

    private static int bfs(int n, int m) {
        Queue<int[]> q = new LinkedList<>();

        boolean flag = true;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (arr[i][j] == 1) q.offer(new int[] {i, j});
                if (arr[i][j] == 0) flag = false;
            }
        }

        if (flag) return 0;

        int day = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] pos = q.poll();
                for(int j = 0; j < 4; j++) {
                    int x = pos[0] + dx[j];
                    int y = pos[1] + dy[j];
                    if (x >= 0 && x < m && y >= 0 && y < n && arr[x][y] == 0) {
                        arr[x][y] = 1;
                        q.offer(new int[] {x, y});
                    }
                }
            }
            day++;
        }
        return day;
    }

    private static boolean check(int n, int m) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
