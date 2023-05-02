package 구현;

import java.util.*;

class PRO_요격시스템 {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int end = -1;
        int answer = 0;

        for (int[] target : targets) {
            int s = target[0];
            int e = target[1];

            if (end <= s) {
                end = e;
                answer++;
            }
        }
        return answer;

    }
}
