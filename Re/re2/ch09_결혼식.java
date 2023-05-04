package Re.re2;

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
        if(this.time == o.time) return this.status - o.status;
        return this.time - o.time;
    }
}

public class ch09_결혼식 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Time> times = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            times.add(new Time(s, 's'));
            times.add(new Time(e, 'e'));
        }

        Collections.sort(times);
        int result = Integer.MIN_VALUE;
        int count = 0;

        for(Time time : times) {
            if (time.status == 's') {
                count++;
                result = Math.max(result, count);
            }
            else count--;
        }

        System.out.println(result);
    }
}
