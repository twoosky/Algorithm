package 구현;

import java.util.Scanner;

class Lamp {
    int d;
    int r;
    int g;
    public Lamp(int d, int r, int g) {
        this.d = d;
        this.r = r;
        this.g = g;
    }
}

public class BOJ_2980 {
    private static Lamp[] lampInfo;
    private static int idx = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // 신호등 개수
        int l = in.nextInt();  // 이동할 거리 (미터)

        lampInfo = new Lamp[n];
        for(int i = 0; i < n; i++) {
            int d = in.nextInt();
            int r = in.nextInt();
            int g = in.nextInt();
            lampInfo[i] = new Lamp(d, r, g);
        }

        // 총 이동시간을 저장하는 변수 선언
        int time = 0;

        // 1미터씩 움직인다.
        for(int i = 0; i < l; i++) {
            time += move(i, time);
        }

        System.out.println(time);
    }

    // 1미터 움직이는데 드는 시간을 반환한다.
    private static int move(int distance, int time) {
        // 신호등이 없는 구간은 이동시간 1초 반환 (1미터에 1초걸리므로)
        if (idx >= lampInfo.length || distance < lampInfo[idx].d) {
            return 1;
        }

        // 현재 위치의 신호등을 가져오고, 인덱스를 1 증켜 다음 신호등을 바라보게 한다.
        Lamp lamp = lampInfo[idx++];

        // 초록색 구간이면 이동시간 1초 반환, 빨간색 구간이면 기다리는 시간 + 이동시간(1초) 반환
        int tmp = time % (lamp.r + lamp.g);
        if (tmp > lamp.r) {
            return 1;
        }
        return lamp.r - tmp + 1;
    }
}
