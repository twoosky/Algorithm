package 인프런.ch5;

import java.util.*;

public class 크레인_인형뽑기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] board = new int[n][n];
        int[] index = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
                if(board[i][j] == 0) {
                    index[j] = i + 1;
                }
            }
        }

        int m = in.nextInt();
        int[] moves = new int[m];
        for(int i = 0; i < m; i++) {
            moves[i] = in.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int pos : moves) {
            for(int i = 0; i < n; i++) {
                if (board[i][pos-1] != 0) {
                    int tmp = board[i][pos-1];
                    board[i][pos-1] = 0;
                    if (!stack.isEmpty() && tmp == stack.peek()) {
                        count += 2;
                        stack.pop();
                    } else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }
        System.out.print(count);
    }

    private static int solution2(int n, int m, int[] moves, int[] index, int[][] board) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < m; i++) {
            int col = moves[i] - 1;
            int row = index[col];
            if (row >= n) {
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(board[row][col]);
            } else {
                int num = stack.peek();
                if (num == board[row][col]) {
                    count += 2;
                    stack.pop();
                } else {
                    stack.push(board[row][col]);
                }
            }
            index[col]++;
        }
        return count;
    }
}
