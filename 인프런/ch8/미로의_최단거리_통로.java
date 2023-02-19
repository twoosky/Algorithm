package 인프런.ch8;

import java.util.*;

public class 미로의_최단거리_통로 {
    private static int[][] graph = new int[7][7];
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 7; j++) {
                graph[i][j] = in.nextInt();
            }
        }

        System.out.print(bfs());
    }

    private static int bfs() {
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(List.of(0, 0, 0));
        graph[0][0] = 1;

        while (!q.isEmpty()) {
            List<Integer> tmp = q.poll();
            if (tmp.get(0) == 6 && tmp.get(1) == 6) {
                return tmp.get(2);
            }

            for(int i = 0; i < 4; i++) {
                int _x = tmp.get(0) + dx[i];
                int _y = tmp.get(1) + dy[i];
                if (_x >= 0 && _x < 7 && _y >= 0 && _y < 7 && graph[_x][_y] == 0) {
                    graph[_x][_y] = 1;
                    q.add(List.of(_x, _y, tmp.get(2) + 1));
                }
            }
        }
        return -1;
    }
}
