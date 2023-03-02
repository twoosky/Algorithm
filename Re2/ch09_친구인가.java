package Re2;

import java.util.*;

public class ch09_친구인가 {
    private static int[] unf;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        unf = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            unf[i] = i;
        }

        for(int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            union(a, b);
        }

        int a = in.nextInt();
        int b = in.nextInt();

        if (find(a) == find(b)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static int find(int v) {
        if (unf[v] == v) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }
    }

    private static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }
}
