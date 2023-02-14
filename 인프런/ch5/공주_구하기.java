package 인프런.ch5;

import java.util.*;

public class 공주_구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < n+1; i++) {
            q.add(i);
        }

        while(q.size() > 1) {
           for(int i = 0; i < k - 1; i++) {
               q.add(q.poll());
           }
           q.poll();
        }
        System.out.print(q.poll());
    }
}
