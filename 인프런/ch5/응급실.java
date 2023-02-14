package 인프런.ch5;

import java.util.*;

class Person {
    int id;
    int priority;
    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class 응급실 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Queue<Person> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            q.add(new Person(i, arr[i]));
        }

        int count = 0;
        while(!q.isEmpty()) {
            Person tmp = q.poll();
            for(Person person : q) {
                if (tmp.priority < person.priority) {
                    q.add(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) count++;
            if (tmp != null && tmp.id == m) break;
        }
        System.out.print(count);
    }

    private static int solution(int[] arr, int m) {
        Queue<Integer> q = new LinkedList<>();
        for(int num : arr) {
            q.add(num);
        }
        int count = 0;
        int pos = m;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int num : q) {
                if (tmp < num) {
                    q.add(tmp);
                    tmp = 0;
                    if (pos == 0) {
                        pos += q.size();
                    }
                    break;
                }
            }
            if (tmp != 0) count++;
            if (tmp != 0 && pos == 0) break;
            pos--;
        }
        return count;
    }
}
