package 이론.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    int score;
    int time;

    public Question(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class DFS_완전탐색 {
    private static int n;
    private static int m;
    private static List<Question> arr;
    private static int result = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();  // 문제 개수
        m = in.nextInt();  // 제한 시간
        arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int score = in.nextInt();  // 점수
            int time = in.nextInt();  // 걸리는 시간
            arr.add(new Question(score, time));
        }

        dfs(0, 0, 0);
        System.out.println(result);
    }

    private static void dfs(int idx, int time, int sum) {
        if (time > m) {
            return;
        }

        if (idx == n) {
            result = Math.max(result, sum);
            return;
        }

        Question question = arr.get(idx);

        // 해당 문제를 푸는 경우
        dfs(idx + 1, time + question.time, sum + question.score);
        // 해당 문제를 풀지 않는 경우
        dfs(idx + 1, time, sum);
    }
}
