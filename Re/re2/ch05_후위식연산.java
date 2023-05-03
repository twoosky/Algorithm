package Re.re2;

import java.util.*;

public class ch05_후위식연산 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split("");

        Stack<Integer> num = new Stack<>();
        for(String value : arr) {
            if (isNumber(value)) {
                num.push(Integer.parseInt(value));
            } else {
                int num1 = num.pop();
                int num2 = num.pop();
                num.push(calculate(num2, num1, value));
            }
        }
        System.out.println(num.pop());
    }

    private static Boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int calculate(int num1, int num2, String s) {
        switch (s) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            default: return num1 / num2;
        }
    }
}
