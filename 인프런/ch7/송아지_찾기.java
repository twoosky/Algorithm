package 인프런.ch7;

import java.util.*;

public class 송아지_찾기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int e = in.nextInt();

        System.out.print(solution(s, e));
    }

    private static int solution(int s, int e) {
        int[] arr = {1, -1, 5};
        int depth = 1;  // jump 횟수가 트리의 깊이와 같다.
        boolean[] visited = new boolean[10001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int current = queue.poll();

                for(int num : arr) {
                    int pos = current + num;
                    if (pos == e) {
                        return depth;
                    }
                    if (pos >= 1 && pos <= 10000 && !visited[pos]) {
                        queue.add(pos);
                        visited[pos] = true;
                    }
                }
            }
            depth++;
        }
        return -1;
    }
}
