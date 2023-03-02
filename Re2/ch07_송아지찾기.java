package Re2;

import java.util.*;

public class ch07_송아지찾기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int e = in.nextInt();
        System.out.print(bfs(s, e));
    }

    private static int bfs(int s, int e) {
        int[] d = {1, -1, 5};
        int depth = 1;
        boolean[] visited = new boolean[100001];
        visited[s] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int now = q.poll();
                for(int j = 0; j < 3; j++) {
                    int pos = now + d[j];
                    if (pos == e) {
                        return depth;
                    }
                    if (pos >= 1 && pos <= 10000 && !visited[pos]) {
                        q.offer(pos);
                        visited[pos] = true;
                    }
                }
            }
            depth++;
        }
        return -1;
    }
}
