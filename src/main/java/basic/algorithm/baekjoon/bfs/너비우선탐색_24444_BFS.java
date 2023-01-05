package basic.algorithm.baekjoon.bfs;

import java.util.*;

public class 너비우선탐색_24444_BFS {

    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> q;
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

        for (int i = 1; i <= vertex + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            int fromVertex = sc.nextInt();
            int toVertex = sc.nextInt();

            graph.get(fromVertex).add(toVertex);
            graph.get(toVertex).add(fromVertex);
        }

        for (int i = 1; i < vertex + 1; i++) {
            Collections.sort(graph.get(i));
        }

        q = new ArrayDeque<>();
        q.add(initialVertex);

        bfs(initialVertex);

        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
    }

    static void bfs(int vertex) {
        visited[vertex] = visitOrder;

        //[1,1], [2,1], [3,1], [1,2], [2,2] ...
        while (!q.isEmpty()) {
            Integer currentVertex = q.poll();

            for (int nextVertex : graph.get(currentVertex)) {
                if (visited[nextVertex] == 0) {
                    visited[nextVertex] = ++visitOrder;
                    q.add(nextVertex);
                }
            }
        }
    }
}
