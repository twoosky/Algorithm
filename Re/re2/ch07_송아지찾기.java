package Re.re2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ch07_송아지찾기 {
    private static boolean[] visited;
    private static final int[] dx = {1, -1, 5};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int e = in.nextInt();
        visited = new boolean[10001];

        System.out.println(bfs(s, e));
    }

    private static int bfs(int s, int e) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {s, 0});
        visited[s] = true;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            for(int d : dx) {
                int new_pos = pos[0] + d;
                if (new_pos < 1 || visited[new_pos]) {
                    continue;
                } else if (new_pos == e) {
                    return pos[1] + 1;
                }
                q.offer(new int[] {new_pos, pos[1] + 1});
                visited[new_pos] = true;
            }
        }
        return -1;
    }
}
