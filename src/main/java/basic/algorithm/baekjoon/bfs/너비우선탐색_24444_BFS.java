package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 너비우선탐색_24444_BFS {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] isVisited;
    static int visitOrder = 1;
    static Queue<Integer> q;

    static int vertexCount;
    static int edgeCount;
    static int startVertex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        vertexCount = Integer.parseInt(s[0]);
        edgeCount = Integer.parseInt(s[1]);
        startVertex = Integer.parseInt(s[2]);

        isVisited = new int[vertexCount + 1];
        q = new LinkedList<>();

        graph = new ArrayList<>();
        for (int i = 0; i < vertexCount + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            String[] v = br.readLine().split(" ");
            int from = Integer.parseInt(v[0]);
            int to = Integer.parseInt(v[1]);

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        bfs(startVertex);

        for (int i = 1; i <= vertexCount; i++) {
            System.out.println(isVisited[i]);
        }
    }

    static void bfs(int start) {
        q.offer(start);
        isVisited[start] = visitOrder;

        while (!q.isEmpty()) {
            Integer v = q.poll();

            for (int i = 0; i < graph.get(v).size(); i++) {
                Integer next = graph.get(v).get(i);

                if (isVisited[next] == 0) {
                    isVisited[next] = ++visitOrder;
                    q.offer(next);
                }
            }
        }
    }
}
