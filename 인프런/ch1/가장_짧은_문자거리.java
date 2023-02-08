package 인프런.ch1;

import java.util.*;

public class 가장_짧은_문자거리 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String str = in.next();
        List<Integer> strIndex = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == str.charAt(0)) {
                strIndex.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (String s : input.split("")) {
            int index = input.indexOf(s);
            result.add(solution(strIndex, index));
        }

        for (int n : result) {
            System.out.print(n + " ");
        }
    }

    private static int solution(List<Integer> strIndex, int index) {
        int result = 1000;
        for(int i : strIndex) {
            if (i > index) {
                result = Math.min(result, i - index);
            } else {
                result = Math.min(result, index - i);
            }
        }
        return result;
    }
}
