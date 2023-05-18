package 구현;

import java.util.*;

class PRO_보석쇼핑 {
    public int[] solution(String[] gems) {

        // HashSet의 size를 통해 구한 보석 종류 변수에 저장
        int kind = new HashSet<>(Arrays.asList(gems)).size();
        // 현재 구간에 포함된 종류별 보석 개수를 저장하기 위한 Map
        Map<String, Integer> map = new HashMap<>();
        // 모든 종류의 보석을 포함하는 구간을 저장하기 위한 리스트
        List<int[]> result = new ArrayList<>();

        // 왼쪽 포인터를 0으로 초기화
        int lt = 0;
        for(int rt = 0; rt < gems.length; rt++) {
            // 이미 존재하는 보석이라면 개수를 1 증가시키고, 존재하지 않는 경우 보석을 Map에 추가 후 개수를 1로 세팅
            map.put(gems[rt], map.getOrDefault(gems[rt], 0) + 1);

            // map의 size는 현재 구간에 포함된 보석의 종류이다. 모든 종류의 보석이 포함되어 있는지 검사
            // 왼쪽 포인터를 하나씩 오른쪽으로 옮겨가며 계속 검사
            while(map.size() == kind) {
                // 모든 종류의 보석이 포함된 구간이므로 result에 구간 삽입
                result.add(new int[] {lt + 1, rt + 1});

                // 왼쪽 포인터에 위치한 보석의 개수 1 감소
                map.put(gems[lt], map.get(gems[lt]) - 1);
                // 왼쪽 포인터에 위치한 보석의 개수가 0이라면 Map에서 해당 보석 삭제 (중요!)
                if (map.get(gems[lt]) == 0) {
                    map.remove(gems[lt]);
                }
                // 왼쪽 포인터 오른쪽으로 1 옮기기
                lt++;
            }
        }

        // 구간이 짧은 순으로 오름차순 정렬, 구간의 길이가 같다면 시작 진열대 번호가 작은 구간 순으로 오름차순 정렬
        Collections.sort(result, (o1, o2) -> {
            int size1 = o1[1] - o1[0];
            int size2 = o2[1] - o2[0];
            if (size1 == size2) return o1[0] - o2[0];
            return size1 - size2;
        });

        // 정렬된 리스트의 0번째 요소 반환
        return result.get(0);
    }
}
