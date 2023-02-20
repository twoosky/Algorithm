package 인프런.ch9;

import java.util.*;

class Speech implements Comparable<Speech>{
    int money;
    int day;
    public Speech(int money, int day) {
        this.money = money;
        this.day = day;
    }

    // 1. this에서 object 값 빼면 오름차순 (1 2 3 4)
    // 2. object에서 this 값 빼면 내림차순 (4 3 2 1)
    @Override
    public int compareTo(Speech o) {
        return o.day - this.day;
    }
}

public class 최대_수입_스케쥴_PriorityQueue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Speech> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new Speech(in.nextInt(), in.nextInt()));
        }

        Collections.sort(list);
        int day = list.get(0).day;  // 가장 큰 day값 추출
        int result = 0;
        Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        while(day > 0) {
            // i 부터 시작, break 후 다음 for문 돌 때 break될 때의 i 값부터 시작
            for(; i < list.size(); i++) {
                Speech speech = list.get(i);
                if (speech.day < day) {
                    break;
                }
                pQ.offer(speech.money);
            }

            if(!pQ.isEmpty()) {
                result += pQ.poll();
            }
            day--;
        }

        System.out.print(result);
    }
}

/*
1. PriorityQueue(우선순위 큐): 가장 작은 값을 먼저 꺼내주는 자료구조
Queue<Integer> pQ = new PriorityQueue<>();

2. 가장 큰 값을 먼저 꺼내고 싶은 경우
Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
 */

/*
1. 날짜를 기준으로 내림차순 정렬 (3 2 2 1 ..)
2. 가장 큰 날짜부터 탐색
3. 해당 날짜의 강연을 우선순위 큐에 모두 삽입
4. 우선순위 큐에서 가장 큰 값을 추출해 result에 더하기
   - 나머지 값은 큐에 계속 존재
   - 다음 날짜의 강연보다 돈이 더 클 수 있음
5. 다음 날짜 강연 우선순위 큐에 모두 삽입 후 4번 반복
5. 마지막 날짜(1)까지 위 과정 반복
6. result에는 최대 강연료가 저장됨 result 출력 끝 !
 */
