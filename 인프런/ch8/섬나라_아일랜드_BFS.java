package 인프런.ch8;

import java.util.*;

class Pos {
    int x;
    int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class 섬나라_아일랜드_BFS {
    private static int[][] board;
    private static int n;
    private static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        board = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    bfs(i, j);
                    result++;
                }
            }
        }

        System.out.print(result);
    }

    private static void bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y));

        while(!q.isEmpty()) {
            Pos point = q.poll();
            for(int i = 0; i < 8; i++) {
                int _x = point.x + dx[i];
                int _y = point.y + dy[i];
                if (_x >= 0 && _x < n && _y >= 0 && _y < n && board[_x][_y] == 1) {
                    board[_x][_y] = 0;
                    q.add(new Pos(_x, _y));
                }
            }
        }
    }
}
