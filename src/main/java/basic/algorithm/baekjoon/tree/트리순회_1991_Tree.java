package basic.algorithm.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리순회_1991_Tree {

    static int N;
    static Node head = new Node("A", null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            addNode(head, root, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
    }

    static class Node{
        String root;
        Node left, right;

        public Node(String root, Node left, Node right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }

    static void addNode(Node head, String root, String left, String right) {
        //현재 root에 도달하면
        if (head.root.equals(root)) {
            head.left = left.equals(".") ? null : new Node(left, null, null);
            head.right = right.equals(".") ? null : new Node(right, null, null);
        } else {
            //'A'부터 입력된 root에 도달할때까지 탐색
            if(head.left != null) addNode(head.left, root, left, right);
            if(head.right != null) addNode(head.right, root, left, right);
        }
    }

    static void preOrder(Node node) {
        System.out.print(node.root);

        if(node.left != null) preOrder(node.left);
        if(node.right != null) preOrder(node.right);
    }

    static void inOrder(Node node) {

        if(node.left != null) inOrder(node.left);
        System.out.print(node.root);
        if(node.right != null) inOrder(node.right);
    }

    static void postOrder(Node node) {
        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        System.out.print(node.root);
    }
}

