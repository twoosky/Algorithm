package Re;

import java.util.*;

public class ch04_최대길이연속부분수열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Queue<Integer> pQ = new PriorityQueue<>();
        int lt = -1;
        int result = 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                if (pQ.size() >= m) {
                    int idx = pQ.poll();
                    result = Math.max(result, sum);
                    sum -= idx - lt;
                    lt = idx;
                }
                pQ.offer(i);
            }
            sum += 1;
        }
        System.out.print(result);
    }
}
