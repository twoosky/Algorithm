package 우선순위큐;

import java.util.*;

class PRO_이중우선순위큐 {
    public int[] solution(String[] operations) {
        // 최대값 우선순위 큐
        Queue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        // 최소값 우선순위 큐
        Queue<Integer> minPQ = new PriorityQueue<>();

        for(String str : operations) {
            if (str.charAt(0) == 'I') {
                int num = Integer.parseInt(str.split(" ")[1]);
                maxPQ.offer(num);
                minPQ.offer(num);
            } else {
                if (maxPQ.isEmpty() || minPQ.isEmpty()) {
                    continue;
                }
                int tmp = Integer.parseInt(str.split(" ")[1]);
                if (tmp == 1) {
                    int val = maxPQ.poll();
                    minPQ.remove(val);
                } else {
                    int val = minPQ.poll();
                    maxPQ.remove(val);
                }
            }
        }

        int[] answer = {0, 0};
        if (!minPQ.isEmpty() || !maxPQ.isEmpty()) {
            answer[0] = maxPQ.poll();
            answer[1] = minPQ.poll();
        }

        return answer;
    }
}
