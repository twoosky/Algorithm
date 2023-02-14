package 인프런.ch5;

import java.util.*;

public class 교육과정_설계 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split("");
        String[] arr = in.nextLine().split("");

        System.out.print(solution(input, arr));
    }

    private static String solution(String[] input, String[] arr) {
        Queue<String> q = new LinkedList<>();
        for(String str : input) {
            q.offer(str);
        }
        for(String str : arr) {
            if (q.contains(str)) {
                if (!q.poll().equals(str)) {
                    return "NO";
                }
            }
        }
        if (!q.isEmpty()) {
            return "NO";
        }
        return "YES";
    }
}
