package Re;

import java.util.*;

class Pos {
    int x;
    int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ch08_피자배달거리 {
    private static List<Pos> house;
    private static List<Pos> list;
    private static Pos[] pizza;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        house = new ArrayList<>();
        pizza = new Pos[m];
        list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (arr[i][j] == 2) {
                    list.add(new Pos(i, j));
                } else if (arr[i][j] == 1) {
                    house.add(new Pos(i, j));
                }
            }
        }

        combi(0, 0, n, m, arr);
        System.out.println(result);
    }

    private static void combi(int start, int depth, int n, int m, int[][] arr) {
        if (depth == m) {
            result = Math.min(result, distance(n, arr));
            return;
        }

        for(int i = start; i < list.size(); i++) {
            pizza[depth] = list.get(i);
            combi(i + 1, depth + 1, n, m, arr);
        }
    }

    private static int distance(int n, int[][] arr) {
        int sum = 0;
        for (Pos hPos : house) {
            int min = Integer.MAX_VALUE;
            for (Pos pPos : pizza) {
                int dis = Math.abs(hPos.x - pPos.x) + Math.abs(hPos.y - pPos.y);
                min = Math.min(min, dis);
            }
            sum += min;
        }
        return sum;
    }
}
