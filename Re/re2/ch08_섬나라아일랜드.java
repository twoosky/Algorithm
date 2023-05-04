package Re.re2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ch08_섬나라아일랜드 {
    private static int[][] arr;
    private static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    private static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = -1;
                    bfs(new int[] {i, j}, n);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void bfs(int[] pos, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(pos);

        while(!q.isEmpty()) {
            int[] node = q.poll();
            for(int i = 0; i < 8; i++) {
                int x = node[0] + dx[i];
                int y = node[1] + dy[i];
                if(x >= 0 && x < n && y >= 0 && y < n && arr[x][y] == 1) {
                    arr[x][y] = -1;
                    q.offer(new int[] {x, y});
                }
            }
        }
    }
}
