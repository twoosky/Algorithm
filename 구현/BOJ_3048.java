package 구현;

import java.util.*;

class Ant {
    char id;
    char direction;

    public Ant(char id, char direction) {
        this.id = id;
        this.direction = direction;
    }
}

public class BOJ_3048 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        in.nextLine();

        // 개미 집단1, 개미 집단2를 입력으로 받는다.
        char[] group1 = in.nextLine().toCharArray();
        char[] group2 = in.nextLine().toCharArray();
        int time = in.nextInt();

        // 개미의 수에 해당하는 배열의 크기를 선언한다.
        Ant[] ants = new Ant[n1 + n2];

        // 개미집단1은 왼쪽에 배치된 개미 집단
        for(int i = 0; i < n1; i++) {
            int idx = n1 - i - 1;
            ants[idx] = new Ant(group1[i], 'L');
        }

        // 개미집단2는 오른쪽에 배치된 개미 집단
        for(int i = 0; i < n2; i++) {
            int idx = n1 + i;
            ants[idx] = new Ant(group2[i], 'R');
        }

        // 입력받은 시간만큼 점프한다.
        for(int i = 0; i < time; i++) {
            jump(ants);
        }

        for(Ant ant : ants) {
            System.out.print(ant.id);
        }
    }

    private static void jump(Ant[] ants) {
        for(int i = 0; i < ants.length - 1; i++) {

            // 왼쪽에 배치되어 있던 개미이고, 그 개미와 오른족에 있는 개미의 방향이 다른 경우 점프한다.
            if (ants[i].direction == 'L' && ants[i].direction != ants[i+1].direction) {
                Ant tmp = ants[i];
                ants[i] = ants[i+1];
                ants[i+1] = tmp;
                i++;
            }
        }
    }
}
