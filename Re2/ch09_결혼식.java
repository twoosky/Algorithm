package Re2;

import java.util.*;

class Time implements Comparable<Time> {
    int time;
    char status;
    public Time(int time, char status) {
        this.time = time;
        this.status = status;
    }

    @Override
    public int compareTo(Time o) {
        if (this.time == o.time) return this.status - o.status;
        return this.time - o.time;
    }
}

public class ch09_결혼식 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Time> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Time(in.nextInt(), 's'));
            list.add(new Time(in.nextInt(), 'e'));
        }

        Collections.sort(list);

        int result = 0;
        int count = 0;
        for(Time time : list) {
            if (time.status == 's') {
                count++;
            } else if (time.status == 'e') {
                result = Math.max(result, count);
                count--;
            }
        }
        System.out.println(result);
    }
}
