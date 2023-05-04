package Re.re2;

import java.util.*;

public class ch08_수열추측하기 {
    private static boolean[] visited;
    private static int[] result;
    private static int[] answer;
    private static boolean flag = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        visited = new boolean[n + 1];
        result = new int[n];
        answer = new int[m];

        dfs(0, n, m);

        for(int num : answer) {
            System.out.print(num + " ");
        }
    }

    private static void dfs(int depth, int n, int m) {
        if (flag) {
            return;
        }

        if (depth == n) {
            if (check(m)) {
                flag = true;
            }
            return;
        }

        for(int i = 1; i <= n; i++) {
            if (!visited[i]) {
                result[depth] = i;
                visited[i] = true;
                dfs(depth + 1, n, m);
                visited[i] = false;
            }
        }
    }

    private static boolean check(int m) {
        Queue<Integer> q = new LinkedList<>();
        for(int num : result) {
            q.offer(num);
        }

        while(q.size() > 1) {
            int size = q.size();
            for(int i = 0; i < size - 1; i++) {
                int num = q.poll() + q.peek();
                q.offer(num);
            }
            q.poll();
        }
        if (m == q.poll()) {
            answer = result.clone();
            return true;
        }
        return false;
    }
}
