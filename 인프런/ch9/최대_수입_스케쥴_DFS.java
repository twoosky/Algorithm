package 인프런.ch9;

import java.util.*;

class Seminar implements Comparable<Seminar>{
    int money;
    int day;
    public Seminar(int money, int day) {
        this.money = money;
        this.day = day;
    }

    // 1. this에서 object 값 빼면 오름차순 (1 2 3 4)
    // 2. object에서 this 값 빼면 내림차순 (4 3 2 1)
    @Override
    public int compareTo(Seminar o) {
        return o.day - this.day;
    }
}

public class 최대_수입_스케쥴_DFS {
    private static List<Seminar> list;
    private static int result = 0;
    private static boolean[] visited;
    private static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        list = new ArrayList<>();
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            list.add(new Seminar(in.nextInt(), in.nextInt()));
        }

        Collections.sort(list);

        dfs(0, 0);
        System.out.print(result);
    }

    /*
    day: 지난 기간 (= depth) (= 강연한 기간)
    sum: 강연료 합계
     */

    private static void dfs(int day, int sum) {
        boolean flag = true;

        for(int i = 0; i < n; i++) {
            Seminar seminar = list.get(i);
            if (seminar.day > day && !visited[i]) {
                visited[i] = true;
                flag = false;
                dfs(day + 1, sum + seminar.money);
                visited[i] = false;
            }
        }

        if (flag) {
            result = Math.max(result, sum);
        }
    }
}

/* 위와 같이 하면 Timeout 발생
DFS로 완전탐색해서 최대값 구하는 방식으로 구현했기 때문.
정석 풀이는 우선순위큐 사용하는 것임
 */