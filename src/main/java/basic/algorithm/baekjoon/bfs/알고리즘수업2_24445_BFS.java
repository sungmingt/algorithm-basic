package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 알고리즘수업2_24445_BFS {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] isVisited;
    static int visitOrder;

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int vertexCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        isVisited = new int[vertexCount + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= vertexCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        bfs(startVertex);

        for (int i = 1; i < isVisited.length; i++) {
            System.out.println(isVisited[i]);
        }
    }

    static void bfs(int start) {
        visitOrder = 1;
        isVisited[start] = visitOrder++;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (int i = 0; i < graph.get(cur).size(); i++) {
                Integer next = graph.get(cur).get(i);

                if (isVisited[next] == 0) {
                    isVisited[next] = visitOrder++;
                    q.offer(next);
                }
            }
        }
    }
}
