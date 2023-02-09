package 인프런.ch4;

import java.util.*;

public class 모든_아나그램_찾기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split("");
        String[] str = in.nextLine().split("");

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(String s : str) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        for(int i = 0; i < str.length - 1; i++) {
            map2.put(arr[i], map2.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0, count = 0;
        for(int rt = str.length - 1; rt < arr.length; rt++) {
            map2.put(arr[rt], map2.getOrDefault(arr[rt] , 0) + 1);
            if(map2.equals(map1)) count++;
            map2.put(arr[lt], map2.get(arr[lt]) - 1);
            if(map2.get(arr[lt]) == 0) map2.remove(arr[lt]);
            lt++;
        }
        System.out.print(count);
    }
}
