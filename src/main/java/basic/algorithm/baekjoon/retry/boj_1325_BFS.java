package basic.algorithm.baekjoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1325_BFS {

    static int V, E;
    static boolean[] isVisited;
    static ArrayList<ArrayList<Integer>> graph;
    static StringTokenizer st;
    static ArrayList<Integer> answer;
    static int maxCount;
    static int curCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        //init graph
        answer = new ArrayList<>();
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());

        //input graph
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(to).add(from);
        }

        for (int i = 1; i <= V; i++) {
            isVisited = new boolean[V + 1];
            curCount = 0;

            bfs(i);

            if (curCount >= maxCount) {
                maxCount = curCount;
                answer.add(i);
            }
        }


        answer.sort(Comparator.comparingInt(o -> o));

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    static void bfs(int vertex) {
        curCount++;
        isVisited[vertex] = true;

        for (int i = 0; i < graph.get(vertex).size(); i++) {
            Integer next = graph.get(vertex).get(i);

            if(isVisited[next]) continue;

            bfs(next);
        }
    }
}
