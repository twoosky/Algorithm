package 인프런.ch5;

import java.util.*;

public class 후위식_연산 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split("");

        Stack<Integer> stack = new Stack<>();
        for(String str : arr) {
            if(isNumber(str)) {
                stack.push(Integer.parseInt(str));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(calculator(num2, num1, str));
            }
        }
        System.out.print(stack.peek());
    }

    private static int calculator(int num1, int num2, String str) {
        switch (str) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2;
            default: return -1;
        }
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
