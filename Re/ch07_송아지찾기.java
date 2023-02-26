package Re;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ch07_송아지찾기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int e = in.nextInt();
        System.out.println(bfs(s, e));
    }

    private static int bfs(int s, int e) {
        int[] arr = {1, -1, 5};
        int count = 0;
        boolean[] visited = new boolean[10001];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int pos = q.poll();
                if (pos == e) {
                    return count;
                }
                for(int num : arr) {
                    int p = pos + num;
                    if (p >= 1 && p < 10000 && !visited[p]) {
                        q.offer(p);
                        visited[p] = true;
                    }
                }
            }
            count++;
        }
        return count;
    }
}
