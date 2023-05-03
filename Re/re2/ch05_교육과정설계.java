package Re.re2;

import java.util.*;

public class ch05_교육과정설계 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] k = in.nextLine().split("");
        String[] n = in.nextLine().split("");

        Queue<String> q = new LinkedList<>();
        for(String s : k) {
            q.offer(s);
        }

        System.out.println(check(n, q));
    }

    private static String check(String[] n, Queue<String> q) {
        for(int i = 0; i < n.length; i++) {
            String str = n[i];
            if (q.contains(str)) {
                if (!q.poll().equals(str)) {
                    return "NO";
                }
            }
        }

        if (!q.isEmpty()) {
            return "NO";
        }
        return "YES";
    }
}
