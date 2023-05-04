package Re.re2;

import java.util.*;

class Seminar implements Comparable<Seminar> {
    int money;
    int day;
    public Seminar(int money, int day) {
        this.money = money;
        this.day = day;
    }

    @Override
    public int compareTo(Seminar o) {
        if (this.day == o.day) return o.money - this.money;
        return o.day - this.day;
    }
}

public class ch09_최대수입스케쥴 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Seminar> seminars = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int money = in.nextInt();
            int day = in.nextInt();
            seminars.add(new Seminar(money, day));
        }

        Collections.sort(seminars);

        PriorityQueue<Seminar> pq = new PriorityQueue<>((o1, o2) -> o2.money - o1.money);
        int day = seminars.get(0).day - 1;
        int idx = 1;
        int result = seminars.get(0).money;

        while(day > 0) {
            for(; idx < seminars.size(); idx++) {
                Seminar seminar = seminars.get(idx);
                if (seminar.day < day) {
                    break;
                }
                pq.offer(seminar);
            }

            if (!pq.isEmpty()) {
                result += pq.poll().money;
            }
            day--;
        }
        System.out.println(result);
    }
}
