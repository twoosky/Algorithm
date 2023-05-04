package Re.re2;

public class ch07_Tree말단노드까지의가장짧은경로DFS {
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        DFS(root, 0);
        System.out.println(result);
    }

    private static void DFS(Node root, int depth) {
        if (depth > result) {
            return;
        }

        if (root.lt == null && root.rt == null) {
            result = Math.min(result, depth);
            return;
        }

        if (root.lt != null) DFS(root.lt, depth + 1);
        if (root.rt != null) DFS(root.rt, depth + 1);
    }
}
