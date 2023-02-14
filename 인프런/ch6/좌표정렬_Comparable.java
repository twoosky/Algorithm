package 인프런.ch6;

import java.util.*;

class Point implements Comparable<Point> {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) return this.y - o.y;
        else return this.x - o.x;
    }

}

public class 좌표정렬_Comparable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Point> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            arr.add(new Point(in.nextInt(), in.nextInt()));
        }

        Collections.sort(arr);

        for(Point point : arr) {
            System.out.println(point.x + " " + point.y);
        }
    }
}

/* 인프런 풀이
- Comparable 인터페이스 구현과 Collections.sort 메서드를 사용하여 풀이
- Collections.sort()의 정렬 기준은 Comparable<T>의 compareTo이다.
*/
