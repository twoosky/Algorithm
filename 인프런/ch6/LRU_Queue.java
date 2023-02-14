package 인프런.ch6;

import java.util.*;

public class LRU_Queue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Queue<Integer> cache = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(!cache.contains(arr[i]) && cache.size() < s) {
                cache.add(arr[i]);
            } else if (cache.contains(arr[i])) {
                int size = cache.size();
                for(int j = 0; j < size; j++) {
                    int tmp = cache.poll();
                    if(tmp != arr[i]) cache.add(tmp);
                }
                cache.add(arr[i]);
            } else {
                cache.poll();
                cache.add(arr[i]);
            }
        }

        int[] result = new int[s];
        for(int i = s - 1; i >= 0; i--) {
            result[i] = cache.poll();
        }
        for(int num : result) {
            System.out.print(num + " ");
        }
    }

    private static void print(Queue<Integer> cache) {
        for(int num : cache) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

/* 내 풀이 Queue를 사용해 구현 */