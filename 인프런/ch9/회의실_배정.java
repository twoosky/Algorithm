package 인프런.ch9;

import java.util.*;

class Time implements Comparable<Time> {
    int start;
    int end;
    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time object) {
        if (this.end == object.end) {
            return this.start - object.start;
        }
        return this.end - object.end;
    }
}

public class 회의실_배정 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Time[] arr = new Time[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new Time(in.nextInt(), in.nextInt());
        }

        Arrays.sort(arr);

        int result = 1;
        int end = arr[0].end;
        for(int i = 1; i < n; i++) {
            Time time = arr[i];
            if (end <= time.start) {
                end = time.end;
                result++;
            }
        }

        System.out.print(result);
    }
}

/* 풀이 설명
1. 끝나는 시간을 기준으로 정렬
2. 끝나는 시간이 같다면, 시작 시간이 빠른 것부터 오름차순 정렬

시작 시간을 기준으로 정렬하면, (1, 7), (2, 5), (5, 7) 인 경우 결과값이 1개가 됨
끝나는 시간을 기준으로 정렬할 것!
 */

/* compareTo()
- 오름차순 정렬하고 싶으면 this - object;
- 내림차순 정렬하고 싶으면 object - this;
 */