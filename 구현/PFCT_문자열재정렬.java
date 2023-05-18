package 구현;

import java.io.*;
import java.util.*;

public class PFCT_문자열재정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int sum = 0;
        List<Character> result = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c)) {
                result.add(c);
            } else {
                sum += (c - '0');
            }
        }

        result.sort((o1, o2) -> o1 - o2);
        for(Character c : result) {
            System.out.print(c);
        }
        System.out.println(sum);
    }
}

/* 입출력 예시
입력: K1KA5CB7
출력: ABCKK13

입력: AJKDLSI412K4JSJ9D
출력: ADDIJJJKKLSS20
 */