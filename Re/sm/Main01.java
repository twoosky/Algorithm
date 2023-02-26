package Re.sm;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] words = new String[n];
        for(int i = 0; i < n; i++) {
            words[i] = in.next();
        }

        int m = in.nextInt();
        String[] keywords = new String[m];
        for(int i = 0; i < m; i++) {
            keywords[i] = in.next();
        }

        int[] result = new int[m];
        int idx = 0;
        for(String keyword : keywords) {
            for(String word : words) {
                if(word.length() >= keyword.length()) {
                    String w = word.substring(0, keyword.length());
                    if (w.equals(keyword)) {
                        result[idx] += 1;
                    }
                }
            }
            idx++;
        }

        for(int num : result) {
            System.out.println(num);
        }
    }
}

/*
4
S
SMNAME
SMSNS
SMBLOG
3
S
SM
SOFTWARE
 */