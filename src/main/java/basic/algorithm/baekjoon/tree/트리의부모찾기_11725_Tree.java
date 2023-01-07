package basic.algorithm.baekjoon.tree;

import java.util.*;

public class 트리의부모찾기_11725_Tree {

    static int[] parentNodeNumber;
    static ArrayList<ArrayList<Integer>> nodes;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        nodes = new ArrayList<>();
        parentNodeNumber = new int[N + 1];
        visited = new boolean[N + 1];

        //ArrayList 초기화
        for (int i = 0; i < N + 1; i++) {
            nodes.add(new ArrayList<>());
        }

        //인접 노드 추가
        for (int i = 0; i < N - 1; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();

            nodes.get(startNode).add(endNode);
            nodes.get(endNode).add(startNode);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();

            for (int i = 0; i < nodes.get(node).size(); i++) {
                int newNode = nodes.get(node).get(i);

                if (!visited[newNode]) {
                    visited[newNode] = true;
                    q.add(newNode);
                    parentNodeNumber[newNode] = node;
                }
            }
        }

        for (int i = 2; i < parentNodeNumber.length; i++) {
            System.out.println(parentNodeNumber[i]);
        }
        
    }
}
