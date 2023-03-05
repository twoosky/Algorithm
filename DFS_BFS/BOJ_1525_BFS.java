package DFS_BFS;

import java.util.*;

public class BOJ_1525_BFS {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                stringBuilder.append(in.nextInt());
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        q.offer(stringBuilder.toString());
        map.put(stringBuilder.toString(), 0);

        while(!q.isEmpty()) {
            String str = q.poll();
            int idx = str.indexOf('0');
            int x = idx / 3;
            int y = idx % 3;

            if(str.equals("123456780")) {
                return map.get(str);
            }

            for(int i = 0; i < 4; i++) {
                int _x = x + dx[i];
                int _y = y + dy[i];
                if (_x >= 0 && _x < 3 && _y >= 0 && _y < 3) {
                    StringBuilder sb = new StringBuilder(str);
                    int numIdx = (_x * 3) + _y;
                    sb.setCharAt(idx, str.charAt(numIdx));
                    sb.setCharAt(numIdx, '0');

                    if (!map.containsKey(sb.toString())) {
                        map.put(sb.toString(), map.get(str) + 1);
                        q.offer(sb.toString());
                    }
                }
            }
        }
        return -1;
    }
}
