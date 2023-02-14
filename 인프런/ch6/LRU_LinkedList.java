package 인프런.ch6;

import java.util.*;

public class LRU_LinkedList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        LinkedList<Integer> cache = new LinkedList<>();
        for(int num : arr) {
            if (cache.contains(num)) {
                cache.remove((Integer) num);
            } else if (cache.size() == s){
                cache.removeLast();
            }
            cache.addFirst(num);
        }

        for(int num : cache) {
            System.out.print(num + " ");
        }
    }
}

/* cache.remove((Integer) num);
- 타입 캐스팅 안해주면 런타임 에러 발생함
*/
