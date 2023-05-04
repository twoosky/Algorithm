package Re.re2;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class ch07_Tree말단노드까지의가장짧은경로BFS {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        System.out.println(BFS(root));
    }

    private static int BFS(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node.lt == null && node.rt == null) {
                    return depth;
                }
                if (node.lt != null) q.offer(node.lt);
                if (node.rt != null) q.offer(node.rt);
            }
            depth++;
        }
        return -1;
    }
}
