package 인프런.ch5;

import java.util.*;

public class 괄호문자제거 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split("");
        Stack<String> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        for(String str : arr) {
            if(str.equals("(")) {
                stack.push(str);
            } else if (str.equals(")")) {
                stack.pop();
            } else {
                if(stack.isEmpty()) {
                    stringBuilder.append(str);
                }
            }
        }
        System.out.print(stringBuilder);
    }
}
