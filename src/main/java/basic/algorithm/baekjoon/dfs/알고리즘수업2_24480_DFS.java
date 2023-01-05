package basic.algorithm.baekjoon.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 알고리즘수업2_24480_DFS {

    static List<ArrayList<Integer>> graph;
    static int[] visited;
    static int visitOrder;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        int initialVertex = sc.nextInt();

        graph = new ArrayList<>();
        visited = new int[vertex + 1];
        visitOrder = 1;

        //graph 초기화
        for (int i = 1; i <= vertex+1; i++) {
            graph.add(new ArrayList<>());
        }

        //graph 채워넣기
        for (int i = 0; i < edge; i++) {
            int startVertex = sc.nextInt();
            int endVertex = sc.nextInt();

            graph.get(startVertex).add(endVertex);
            graph.get(endVertex).add(startVertex);
        }

        //내림차순 정렬
        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        dfs(initialVertex);

        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }

    }

    static void dfs(int vertex){
        visited[vertex] = visitOrder;

        for (int i = 0; i < graph.get(vertex).size(); i++) {
            Integer toVertex = graph.get(vertex).get(i);

            if (visited[toVertex] == 0) {
                visitOrder++;
                dfs(toVertex);
            }
        }
    }
}
