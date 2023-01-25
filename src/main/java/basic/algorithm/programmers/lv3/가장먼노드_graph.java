package basic.algorithm.programmers.lv3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장먼노드_graph { //복습

    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] values;
    static int maxValue;
    static int maxCount;

    static int solution(int n, int[][] edge) {
        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        values = new int[n + 1];

        //graph 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        //edge 추가
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.offer(1);

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (int i = 0; i < graph.get(cur).size(); i++) {
                Integer newVertex = graph.get(cur).get(i);

                if (!visited[newVertex]) {
                    q.offer(newVertex);
                    values[newVertex] = values[cur] + 1; //bfs이기 때문에 방문 순서는 (이전 노드 + 1)이다.
                    visited[newVertex] = true;
                }
            }
        }

        //가장 큰 수들의 개수 계산
        for (int value : values) {
            if (value > maxValue) {
                maxValue = value;
                maxCount = 1;
            } else if (value == maxValue) {
                maxCount++;
            }
        }

        return maxCount;
    }
}
