package Re.re2;

import java.util.*;

//class Node {
//    int data;
//    Node lt, rt;
//    public Node(int val) {
//        data = val;
//        lt=rt=null;
//    }
//}

public class ch07_이진트리순회DFS {
    private static List<Integer> preOrder = new ArrayList<>();
    private static List<Integer> midOrder = new ArrayList<>();
    private static List<Integer> postOrder = new ArrayList<>();

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        DFS(root);

        printOrder("전위순회", preOrder);
        printOrder("중위순회", midOrder);
        printOrder("후위순회", postOrder);
    }

    private static void DFS(Node root) {
        if (root == null) return;  // 말단 노드
        else {
            preOrder.add(root.data);
            DFS(root.lt);
            midOrder.add(root.data);
            DFS(root.rt);
            postOrder.add(root.data);
        }
    }

    private static void printOrder(String type, List<Integer> order) {
        System.out.print(type + ": ");
        for(int num : order) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
