package 구현;

import java.util.*;

class PRO_인사고과 {
    public int solution(int[][] scores) {
        int answer = -1;

        int[] target = scores[0];

        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            return o2[0] - o1[0];
        });

        List<int[]> result = new ArrayList<>();
        result.add(scores[0]);
        int max = scores[0][1];
        for(int i = 1; i < scores.length; i++) {
            int[] score1 = scores[i-1];
            int[] score2 = scores[i];
            if (score1[0] == score2[0] || max < score2[1]) {
                max = score2[1];
                result.add(score2);
            }
        }

        Collections.sort(result, (o1, o2) -> {
            return (o2[0] + o2[1]) - (o1[0] + o1[1]);
        });

        for(int i = 0; i < result.size(); i++) {
            int[] score = result.get(i);
            if (score[0] == target[0] && score[1] == target[1]) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }
}
