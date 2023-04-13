package 그리디;

import java.util.*;

class Food implements Comparable<Food> {
    int idx;
    int time;

    public Food(int idx, int time) {
        this.idx = idx;
        this.time = time;
    }

    @Override
    public int compareTo(Food o) {
        if (this.time == o.time) return this.idx - o.idx;
        return this.time - o.time;
    }
}

public class PFCT_무지의먹방라이브 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(",");
        int k = in.nextInt();

        int[] food_times = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            food_times[i] = Integer.parseInt(input[i]);
        }

        long summary = 0;
        for (int food_time : food_times) {
            summary += food_time;
        }
        if (summary <= k) System.out.println("-1");

        Queue<Food> pq = new PriorityQueue<>();
        for(int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(i, food_times[i]));
        }

        long previous = 0;
        long length = pq.size();
        while(length > 0) {
            Food food = pq.peek();
            long gap = food.time - previous;
            long use_time = gap * pq.size();

            if (use_time > k) {
                break;
            }

            k -= use_time;
            pq.poll();
            length--;
            previous = food.time;
        }

        List<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.sort(result, (o1, o2) -> o1.idx - o2.idx);

        int answer = k % result.size() + 1;
        System.out.println(answer);
    }
}

/*
[내 풀이]
- k를 기준으로 순회하는 방식으로 풀이
- 시간초과 발생

public class PFCT_무지의먹방라이브 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(",");
        int k = in.nextInt();

        int[] foodTimes = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            foodTimes[i] = Integer.parseInt(input[i]);
        }

        int idx = 0;
        while(k > 0) {
            if (foodTimes[idx] > 0) {
                k--;
                foodTimes[idx] -= 1;
            }
            idx = (idx + 1) % foodTimes.length;
        }

        if (isTimeOver(foodTimes)) {
            idx = 0;
        }

        System.out.println(idx + 1);
    }

    private static boolean isTimeOver(int[] foodTimes) {
        for(int time : foodTimes) {
            if (time > 0) {
                return false;
            }
        }
        return true;
    }
}
 */
