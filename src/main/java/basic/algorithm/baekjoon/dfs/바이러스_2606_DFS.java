package basic.algorithm.baekjoon.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class 바이러스_2606_DFS {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int infectedCount;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edge = sc.nextInt();

        visited = new boolean[vertex + 1];
        graph = new ArrayList<>();
        for (int i = 0; i < vertex + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            int fromVertex = sc.nextInt();
            int toVertex = sc.nextInt();

            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }

        dfs(1);

        System.out.println(infectedCount);
    }

    static void dfs(int vertex) {
        visited[vertex] = true;

        for (int i = 0; i < graph.get(vertex).size(); i++) {
            Integer targetVertex = graph.get(vertex).get(i);

            if (!visited[targetVertex]) { //false(미방문)일 경우 방문한다
                dfs(targetVertex);
                infectedCount++;
            }
        }
    }
}
