package 인프런.ch5;

import java.util.*;

public class 올바른_괄호 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split("");

        System.out.print(solution(arr));
    }

    private static String solution(String[] arr) {
        Stack<String> stack = new Stack<>();
        for(String str : arr) {
            if (str.equals("(")) {
                stack.push(str);
            } else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if (stack.isEmpty()) return "YES";
        else return "NO";
    }
}
