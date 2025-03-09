package basic.algorithm.baekjoon.retry.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진검색트리_5639_Tree { //이진 탐색 트리를 구현

    //배열로 빠르게 푸는 풀이방법 : https://recordofwonseok.tistory.com/430
    static int size;

    public static void main(String[] args) throws IOException {
        //전위 순회를 기반으로 후위 순회 결과를 출력
        //pre : 50 30 24 5 28 45 98 52 60
        //post : 5 28 24 45 30 60 52 98 50

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int root = Integer.parseInt(br.readLine());
        Node rootNode = new Node(root, null, null);

        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) break;
            rootNode.addNode(Integer.parseInt(input));
        }

        postOrder(rootNode);
    }

    static class Node{
        int root;
        Node left;
        Node right;

        public Node(int root, Node left, Node right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }

        void addNode(int num) {
            //입력값이 현재 노드보다 작은 경우
            if (num < root) {
                //왼쪽 자식 노드가 비어있을 경우
                if (left == null) {
                    this.left = new Node(num, null, null);
                } else { //자식 노드가 이미 있을 경우 -> 계속 탐색
                    this.left.addNode(num);
                }
            }
            //입력값이 현재 노드보다 큰 경우
            else {
                //오른쪽 자식 노드가 비어있을 경우
                if (right == null) {
                    this.right = new Node(num, null, null);
                } else { //자식 노드가 이미 있을 경우 -> 계속 탐색
                    this.right.addNode(num);
                }
            }
        }
    }

    static void postOrder(Node node) {
        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        System.out.println(node.root);
    }
}
