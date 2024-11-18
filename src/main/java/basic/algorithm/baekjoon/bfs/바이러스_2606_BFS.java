package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 바이러스_2606_BFS {

    static int vertex, edge;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] isVisited;
    static int infectCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vertex = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        isVisited = new boolean[vertex + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            String[] s = br.readLine().split(" ");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        bfs(1);

        System.out.println(infectCount);

    }

    static void bfs(int vertex) {
        isVisited[vertex] = true;

        for (int i = 0; i < graph.get(vertex).size(); i++) {
            Integer target = graph.get(vertex).get(i);

            //이미 방문했다면
            if (isVisited[target]) {
                continue;
            }

            infectCount++;
            bfs(target);
        }
    }
}
