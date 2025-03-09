package basic.algorithm.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1260_DFS_DFS {

    static Queue<Integer> q;
    static List<ArrayList<Integer>> graph;
    static boolean[] isVisited;
    static int V, E, I;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        I = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        isVisited = new boolean[V + 1];

        //init graph
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        //graph 오름차순 정렬
        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        dfs(I);

        System.out.println();
        isVisited = new boolean[V + 1];
        isVisited[I] = true;

        q = new ArrayDeque<>();
        System.out.print(I + " ");
        q.add(I);
        bfs();
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Integer curVertex = q.poll();

            for (int i = 0; i < graph.get(curVertex).size(); i++) { //contains 또는 배열 만들어 방문여부 따로 관리
                Integer targetVertex = graph.get(curVertex).get(i);

                if (isVisited[targetVertex]) continue;

                isVisited[targetVertex] = true;
                q.add(targetVertex);
                System.out.print(targetVertex + " ");
            }
        }
    }

    static void dfs(int vertex) {
        System.out.print(vertex + " ");
        isVisited[vertex] = true;

        for (int i = 0; i < graph.get(vertex).size(); i++) {
            Integer next = graph.get(vertex).get(i);

            if (isVisited[next]) continue;

            dfs(next);
        }
    }
}