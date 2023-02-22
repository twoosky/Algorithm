package DFS_BFS;

import java.util.*;

class PRO_여행경로 {
    private static List<String> result;
    private static boolean[] visited;

    public String[] solution(String[][] tickets) {
        result = new ArrayList<>();
        visited = new boolean[tickets.length];

        dfs("ICN", "ICN", 0, tickets);

        Collections.sort(result);
        String[] answer = result.get(0).split(" ");

        return answer;
    }

    private void dfs(String start, String route, int depth, String[][] tickets) {
        if (depth == tickets.length) {
            result.add(route);
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];
            if(ticket[0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(ticket[1], route + " " + ticket[1], depth + 1, tickets);
                visited[i] = false;
            }
        }
    }
}
