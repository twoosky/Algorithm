package 인프런.ch4;

import java.util.*;

public class 학급_회장 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = in.next().split("");
        Map<String, Integer> map = new HashMap<>();

        for(String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int max = 0;
        String result = "";
        for(String key : map.keySet()) {
            if (max < map.get(key)) {
                max = map.get(key);
                result = key;
            }
        }
        System.out.print(result);
    }
}
