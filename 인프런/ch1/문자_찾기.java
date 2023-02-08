package 인프런.ch1;

import java.util.*;

public class 문자_찾기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next().toLowerCase();
        char c = in.next().toLowerCase().charAt(0);
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }
        System.out.print(count);
    }
}
