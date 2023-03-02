package Re2;

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
    private static List<Pos> pizzas;
    private static Pos[] pickPizza;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        pickPizza = new Pos[m];
        pizzas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 2) {
                    pizzas.add(new Pos(i, j));
                }
            }
        }

        combi(0, 0, m, arr);
        System.out.println(result);
    }

    private static void combi(int start, int depth, int m, int[][] arr) {
        if (depth == m) {
            result = Math.min(result, check(arr));
            return;
        }

        for(int i = start; i < pizzas.size(); i++) {
            pickPizza[depth] = pizzas.get(i);
            combi(i + 1, depth + 1, m, arr);
        }
    }

    private static int check(int[][] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++){
                if (arr[i][j] == 1) {
                    int min = Integer.MAX_VALUE;
                    for (Pos pos : pickPizza) {
                        int distance = Math.abs(i - pos.x) + Math.abs(j - pos.y);
                        min = Math.min(min, distance);
                    }
                    sum += min;
                }
            }
        }
        return sum;
    }
}
