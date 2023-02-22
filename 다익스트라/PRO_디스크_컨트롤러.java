package 다익스트라;

import java.util.*;

class PRO_디스크_컨트롤러 {
    public int solution(int[][] jobs) {

        // 1. 요청 시간을 기준으로 오름차순 정렬 (0 1 2)
        Arrays.sort(jobs, (o1, o2) ->  {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        for(int[] job : jobs) {
            System.out.println(job[0] + " " + job[1]);
        }

        // 2. 우선순위 큐 정렬 기준은 작업 소요 시간 오름차순 (3, 1), (2, 6), (1, 9)
        Queue<int[]> pQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int idx = 1;     // jobs 배열의 인덱스
        int count = 1;   // 수행된 요청 개수
        int answer = jobs[0][1];   // 작업하는데 총 걸린 시간
        int workEnd = jobs[0][0] + jobs[0][1];  // 수행되고 난 직후의 시간

        while(count < jobs.length) {
            for(; idx < jobs.length; idx++) {
                if (workEnd < jobs[idx][0]) {
                    break;
                }
                pQ.offer(jobs[idx]);
            }

            if (pQ.isEmpty()) {
                workEnd++;
                continue;
            }

            int[] job = pQ.poll();
            answer += job[1] + (workEnd - job[0]);
            workEnd += job[1];
            count++;
        }

        return answer / jobs.length;
    }
}


/*
1. jobs 배열을 요청 시간이 빠른 순으로 정렬
  - 주의: 요청 시간이 같은 경우 소요 시간이 짧은 순으로 정렬
  - 이거 고려 안했다가 계속 실패함
2. 요청 시간이 빠른 순으로 정렬했으므로, 0번 인덱스의 작업이 처음 작업이다.
   따라서 0번 인덱스 이후 작업부터 탐색
3. 0번 인덱스 작업에 따른 count, answer, idx, workEnd 초기화

[while]
4. 모든 작업을 끝낼 때까지 즉, count값이 jobs 배열의 길이보다 작을 때까지 반복

[for]
5. 1번 인덱스부터 탐색
6. 0번 작업 수행이 끝난 시점보다 전에 요청이 들어온 작업은 우선순위 큐에 삽입
7. 0번 작업 수행이 끝난 시점 이후에 들어오는 작업인 경우 break
  - 해당 인덱스 (idx)를 저장하고 있다가 다음엔 해당 인덱스 작업부터 탐색
  - 이해 안되면 [인프런 - ch9 - 최대_수입_스케쥴_PriorityQueue] 참고

[if]
8. 만약 우선순위 큐가 비어있다면 현재 시점에 수행할 수 있는 작업이 없는 것임
  - 작업 사이 공백이 있는 경우
9. 마지막 작업이 수행된 시간인 workEnd값을 1씩 증가하며 5 ~ 7번 과정반복

[pQ.poll()]
10. 우선순위 큐에서 작업 소요시간이 가장 작은 작업을 꺼내 수행
  - 작업 요청 시간은 고려 안해도됨
  - 우선순위 큐에 들어간 작업들은 모두 당장 수행 가능한 작업들임 (6번 과정에 의해)
11. answer에 해당 작업이 요청부터 종료까지 걸린 시간을 더한다.
  - 요청부터 종료까지 걸린 시간: (해당 작업 소요 시간 + 마지막 작업 수행 시간 - 해당 작업 시작 시간)
12. 마지막 작업이 수행된 시간도 업데이트한다.
  - workEnd = 마지막 작업 수행 시간(workEnd) + 해당 작업 소요 시간
13. 작업 하나를 수행했으므로 count값 1 증가
 */