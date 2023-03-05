package 구현;

import java.util.*;

class PRO_인사고과 {
    public int solution(int[][] scores) {
        int[] target = scores[0];

        // 1. 근무 태도 점수는 내림차순 정렬, 동료 평가 점수는 오름차순 정렬
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });

        /*
        - 내 앞에 동료평가점수가 나보다 높은사람이 한명이라도 있으면 탈락
        - 근무태도 동점자의 경우 동료평가 오름차순 하였으므로 고려하지 않아도 됨
         */

        int answer = 1;
        int maxScore = -1;
        for(int i = 0; i < scores.length; i++) {
            if (scores[i][1] < maxScore) {
                if (scores[i][0] == target[0] && scores[i][1] == target[1]) {
                    return -1;
                }
            } else {
                if (scores[i][0] + scores[i][1] > target[0] + target[1]) {
                    answer++;
                }
                maxScore = Math.max(maxScore, scores[i][1]);
            }
        }

        return answer;
    }
}
