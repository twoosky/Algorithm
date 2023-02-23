package 우선순위큐;

import java.util.*;

class PRO_더맵게 {
    // 내 풀이
    public int solution(int[] scoville, int K) {
        int answer = 0;

        Queue<Integer> pQ = new PriorityQueue<>();
        for(int num : scoville) {
            pQ.offer(num);
        }

        while(!pQ.isEmpty()) {
            int weekHot = pQ.poll();

            if (weekHot >= K) {
                continue;
            }

            if (pQ.isEmpty()) {
                answer = -1;
                break;
            }

            int secondWeekHot = pQ.poll();
            int mixHot = weekHot + (secondWeekHot * 2);
            pQ.offer(mixHot);
            answer++;
        }
        return answer;
    }

   /* 다른 사람 풀이
     1. 우선순위 큐이므로, pQ.peek()이 K값보다 크거나 같다면 더이상 검사할 필요가 없다. (남은 원소들도 K보다 크거나 같은 것이므로)
     2. pQ.peek()이 K보다 작은데, 원소가 1개밖에 없다 -> 스코빌 지수를 만들 수 없으므로, -1 반환
    */
    public int solution2(int[] scoville, int K) {
        int answer = 0;

        Queue<Integer> pQ = new PriorityQueue<>();
        for(int num : scoville) {
            pQ.offer(num);
        }

        while(pQ.peek() < K) {
            if (pQ.size() == 1) {
                return -1;
            }

            int weekHot = pQ.poll();
            int secondWeekHot = pQ.poll();
            int mixHot = weekHot + (secondWeekHot * 2);

            pQ.offer(mixHot);
            answer++;
        }
        return answer;
    }
}
