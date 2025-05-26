package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1325_bfs {

    static int V, E;
    static boolean[] isVisited;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] result; //result[i] = i번째 컴퓨터를 해킹했을때 해킹할수 있는 컴퓨터의 수
    static int maxCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        result = new int[V + 1];

        //init graph
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        //input graph
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(to).add(from);
        }

        //bfs
        for (int i = 1; i <= V; i++) {
            isVisited = new boolean[V + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            isVisited[i] = true;

            int count = 0;

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int next : graph.get(cur)) {
                    if (!isVisited[next]) {
                        isVisited[next] = true;
                        queue.add(next);
                        count++;
                    }
                }
            }

            result[i] = count;
            maxCount = Math.max(maxCount, count);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= result.length; i++) {
            if (result[i] == maxCount) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}
