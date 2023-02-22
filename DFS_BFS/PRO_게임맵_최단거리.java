package DFS_BFS;

import java.util.*;

class Pos {
    int x;
    int y;
    int depth;
    public Pos(int x, int y, int depth) {
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

class PRO_게임맵_최단거리 {
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public int solution(int[][] maps) {

        int answer = bfs(maps);
        return answer;
    }

    private static int bfs(int[][] maps) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0, 0));

        while(!q.isEmpty()) {
            Pos pos = q.poll();

            if (pos.x == maps.length - 1 && pos.y == maps[pos.x].length - 1) {
                return pos.depth + 1;
            }

            for(int i = 0; i < 4; i++) {
                int _x = pos.x + dx[i];
                int _y = pos.y + dy[i];
                if (_x >= 0 && _x < maps.length && _y >= 0 && _y < maps[_x].length && maps[_x][_y] == 1) {
                    maps[_x][_y] = 0;
                    q.add(new Pos(_x, _y, pos.depth + 1));
                }
            }
        }
        return -1;
    }
}
