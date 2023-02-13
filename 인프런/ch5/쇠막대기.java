package 인프런.ch5;

import java.util.*;

public class 쇠막대기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split("");
        Stack<String> stack = new Stack<>();

        int result = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals("(")) {
                stack.add(arr[i]);
            } else {
                if(arr[i-1].equals("(")) {
                    stack.pop();
                    if(stack.isEmpty()) {
                        continue;
                    }
                    result += stack.size();
                } else {
                    result += 1;
                    stack.pop();
                }
            }
        }
        System.out.print(result);
    }
}
