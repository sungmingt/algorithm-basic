package basic.algorithm.baekjoon.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class 트리의지름_1967_Tree {

    static ArrayList<Node>[] tree; //key : 노드, value : 길이
    static boolean[] visited;
    static int maxLength;
    static int targetNode;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        tree = new ArrayList[N + 1];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int fromVertex = sc.nextInt();
            int toVertex = sc.nextInt();
            int edgeLength = sc.nextInt();

            tree[fromVertex].add(new Node(toVertex, edgeLength));
            tree[toVertex].add(new Node(fromVertex, edgeLength));
        }

        visited = new boolean[N + 1];
        dfs(1, 0);

        visited = new boolean[N + 1];
        dfs(targetNode, 0);

        System.out.println(maxLength);
    }

    static void dfs(int vertex, int length) {

        if (length > maxLength) {
            maxLength = length;
            targetNode = vertex;
        }

        visited[vertex] = true;

        for (int i = 0; i < tree[vertex].size(); i++) {
            Node target = tree[vertex].get(i);

            if (!visited[target.vertex]) {
                dfs(target.vertex, length + target.cost);
                visited[target.vertex] = false;
            }
        }
    }

    static class Node{
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}


