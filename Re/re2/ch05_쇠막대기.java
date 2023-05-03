package Re.re2;

import java.util.Scanner;
import java.util.Stack;

public class ch05_쇠막대기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split("");

        Stack<String> stack = new Stack<>();
        int result = 0;

        for(int i = 0; i < arr.length; i++) {
            String str = arr[i];
            if (str.equals("(")) {
                stack.push(str);
                continue;
            }

            String pre = arr[i-1];
            if (pre.equals("(")) {
                stack.pop();
                result += stack.size();
                continue;
            }
            result += 1;
            stack.pop();
        }

        System.out.println(result);
    }
}
