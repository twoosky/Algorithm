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
        if (this.day == o.day) return o.money - this.money;
        return this.day - o.day;
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

        dfs(0, 0, 0);
        System.out.print(result);
    }

    private static void dfs(int day, int sum, int seminarDay) {
        Seminar lastSeminar = list.get(list.size() - 1);

        if (seminarDay == lastSeminar.day) {
            result = Math.max(result, sum);
            return;
        }

        for(int i = 0; i < n; i++) {
            Seminar seminar = list.get(i);
            if (seminar.day > day && !visited[i]) {
                visited[i] = true;
                dfs(day + 1, sum + seminar.money, seminar.day);
                visited[i] = false;
            }
        }
    }
}

/* 아래와 같이 정렬 (day 기준 오름차순 정렬)
30 1
20 1
50 2
40 2
60 3
30 3
 */