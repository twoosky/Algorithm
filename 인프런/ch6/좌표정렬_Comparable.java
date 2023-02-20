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

/* compareTo()
- this와 object 연산 시 음수가 반환되어야 한다.
- 오름차순 정렬하고 싶으면 this - object;
- 내림차순 정렬하고 싶으면 object - this;

- this가 10, object가 20이라 할 때, 아래와 같이 반환해야 원하는대로 정렬됨
- 오름차순 정렬(10, 20): this.x - object.x
- 내림차순 정렬(20, 10): object.x - this.x
 */