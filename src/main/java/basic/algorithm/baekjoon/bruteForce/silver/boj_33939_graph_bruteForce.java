package basic.algorithm.baekjoon.bruteForce.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_33939_graph_bruteForce {

    static int N, M;
    static List<ArrayList<Integer>> graph;
    static int notRelatedCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        //init graph
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        //input edges
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(to).add(from); //반대로 저장.
        }

        //정점들을 순차 탐색한다.
        //graph.get(i) -> i로 가는 간선이 존재하는 정점들.
        //graph.get(i)를 탐색하며, 요소들 간에 간선이 있는지 비교하면 됨.

        for (int i = 1; i <= N; i++) {
            ArrayList<Integer> arr = graph.get(i);

            //현재 탐색 정점으로의 간선이 존재하는 정점들 탐색
            for (int k = 0; k < arr.size() - 1; k++) {
                for (int p = k + 1; p < arr.size(); p++) {
                    Integer a = arr.get(k);
                    Integer b = arr.get(p);

                    if (proveNotRelated(a, b)) {
                        notRelatedCnt++;
                    }
                }
            }
        }

        System.out.println(notRelatedCnt);
    }

    private static boolean proveNotRelated(int a, int b) {
        ArrayList<Integer> aEdges = graph.get(a);
        ArrayList<Integer> bEdges = graph.get(b);

        for (int target : aEdges) {
            if (target == b) {
                return false;
            }
        }

        for (int target : bEdges) {
            if (target == a) {
                return false;
            }
        }

        return true;
    }
}
