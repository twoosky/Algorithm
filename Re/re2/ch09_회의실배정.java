package Re.re2;

import java.util.*;

class Meet implements Comparable<Meet> {
    int s;
    int e;
    public Meet(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Meet o) {
        if(this.e == o.e) return this.s - o.s;
        return this.e - o.e;
    }
}

public class ch09_회의실배정 {
    private static List<Meet> meets = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            meets.add(new Meet(s, e));
        }

        Collections.sort(meets);

        int count = 1;
        int end = meets.get(0).e;

        for(int i = 1; i < n; i++) {
            Meet meet = meets.get(i);
            if (meet.s >= end) {
                end = meet.e;
                count++;
            }
        }
        System.out.println(count);
    }
}
