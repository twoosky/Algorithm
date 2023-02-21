package 인프런.ch10;

import java.util.*;

class Brick implements Comparable<Brick> {
    int area;
    int height;
    int weight;
    public Brick(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick o) {
        return o.weight - this.weight;
    }
}

public class 가장_높은_탑_쌓기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Queue<Brick> pQ = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            int area = in.nextInt();
            int height = in.nextInt();
            int weight = in.nextInt();
            pQ.offer(new Brick(area, height, weight));
        }

        int result = 0;
        while(!pQ.isEmpty()) {
            Brick brick = pQ.poll();
            int sum = brick.height;
            int area = brick.area;
            for(Brick tmp : pQ) {
                if (area > tmp.area) {
                    area = tmp.area;
                    sum += tmp.height;
                }
            }
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }
}
