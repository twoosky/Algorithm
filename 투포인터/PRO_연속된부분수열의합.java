package 투포인터;

import java.util.*;

class PRO_연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        List<int[]> result = new ArrayList<>();
        int left = 0;
        int sum = 0;

        for(int i = 0; i < sequence.length; i++) {
            sum += sequence[i];
            while (sum > k) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                int[] arr = new int[2];
                arr[0] = left;
                arr[1] = i;
                result.add(arr);
            }
        }

        Collections.sort(result, (o1, o2) -> {
            int length = (o1[1]-o1[0]) - (o2[1]-o2[0]);
            if (length == 0) return o1[0] - o2[0];
            return length;
        });

        answer[0] = result.get(0)[0];
        answer[1] = result.get(0)[1];

        return answer;
    }
}
