package Re.re2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//class Node {
//    int data;
//    Node lt, rt;
//    public Node(int val) {
//        data = val;
//        lt=rt=null;
//    }
//}

public class ch07_이진트리순회BFS {
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        BFS(root);

        for(int num : result) {
            System.out.print(num + " ");
        }
    }

    private static void BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            Node node = q.poll();
            result.add(node.data);

            if (node.lt != null) q.offer(node.lt);
            if (node.rt != null) q.offer(node.rt);
        }
    }
}
