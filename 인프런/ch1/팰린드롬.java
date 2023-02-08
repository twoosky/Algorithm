package 인프런.ch1;

import java.util.*;

public class 팰린드롬 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String origin = input.toLowerCase().replaceAll("[^A-Z]", "");

        StringBuilder stringBuilder = new StringBuilder(origin);
        String reverse = stringBuilder.reverse().toString();

        if (origin.equals(reverse)) {
            System.out.print("YES");
        } else{
            System.out.println("NO");
        }
    }
}
