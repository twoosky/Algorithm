package 인프런.ch4;

import java.util.*;

public class 아나그램 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr1 = in.nextLine().split("");
        String[] arr2 = in.nextLine().split("");
        Map<String, Integer> map = new HashMap<>();

        for(String str : arr1) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        System.out.print(solution(map, arr2));
    }

    private static String solution(Map<String, Integer> map, String[] arr) {
        for(String str : arr) {
            if (!map.containsKey(str) || map.get(str) < 0) return "NO";
            map.put(str, map.get(str) - 1);
        }
        return "YES";
    }
}
