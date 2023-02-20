package 인프런.ch9;

import java.util.*;

class Stay implements Comparable<Stay> {
    int time;
    char status;  // s: 도착 시간, e: 떠나는 시간
    public Stay(int time, char status) {
        this.time = time;
        this.status = status;
    }

    // String은 안됨. 문자 비교 경우 char 타입 사용해야 한다.
    @Override
    public int compareTo(Stay object) {
        if (this.time == object.time) return this.status - object.status;
        return this.time - object.time;
    }
}

public class 결혼식 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Stay> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new Stay(in.nextInt(), 's'));
            list.add(new Stay(in.nextInt(), 'e'));
        }

        Collections.sort(list);
        int result = 0;
        int count = 0;
        for(Stay stay : list) {
            if (stay.status == 's') {
                count++;
            } else if (stay.status == 'e') {
                result = Math.max(result, count);
                count--;
            }
        }

        System.out.print(result);
    }
}

/*
정렬 기준
1. 시간과 도착 시간/가는 시간 종류를 쪼개 저장
2. 시간을 기준으로 오름차순 정렬
3. 시간이 같은 경우 도착 시간(s)이 떠나는 시간(e)보다 앞에 오도록 정렬
- 오는 시간 13, 가는시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는 것이고 15시 정각에는 존재하지 않는다고 가정하기 때문

로직
- 시간 별로 정렬되어 있으므로 status만 보고 count를 업데이트하면 된다.
- s인 경우 count++, e인 경우 count--

- 도착 시간과 떠나는 시간이 같은 경우 떠나는 것을 먼저 계산 후 도착하는 것을 계산해야함
- (5시 도착, 14 떠남), (14 도착, 18시 떠남) 이때 동시에 존재하는 최대 인원은 1이다.
- 만약 도착하는 것을 먼저 계산하는 경우 5시(count++), 14시(count++)한 뒤 14시(count--)가 되므로 최대 인원이 2로 계산된다.
 */

/* 아래와 같이 정렬되어야 한다.
5 s
12 s
14 e
14 s
15 e
15 s
18 e
20 e
20 s
30 e
 */
