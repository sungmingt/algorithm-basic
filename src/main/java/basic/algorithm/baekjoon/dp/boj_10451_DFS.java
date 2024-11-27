package basic.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10451_DFS {

    static int[] arr;
    static boolean[] isVisited;
    static int T, V;
    static StringTokenizer st;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        //test cases
        for (int i = 0; i < T; i++) {
            count = 0;
            V = Integer.parseInt(br.readLine());
            arr = new int[V + 1];
            isVisited = new boolean[V + 1];

            //input numbers
            st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= V; k++) {
                int input = Integer.parseInt(st.nextToken());
                arr[k] = input;
            }

            //dfs
            for (int p = 1; p <= V; p++) {
                if(isVisited[p]) continue;

                dfs(p);
            }

            System.out.println(count);
        }
    }

    static void dfs(int vertex) {
        //사이클이 있으면
        if(isVisited[vertex]){
            count++;
            return;
        }

        isVisited[vertex] = true;
        int next = arr[vertex];
        dfs(next);
    }
}
