package basic.algorithm.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10451_DFS {

    static int[] arr;
    static boolean[] isVisited;
    static int T;
    static int N;
    static StringTokenizer st;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            //init
            count = 0;
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            isVisited = new boolean[N + 1];

            //input
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //각 수로부터 dfs 탐색을 시작. 모두 방문했을때 처음 수로 돌아오면 사이클이 있는 것
            //  하나의 요소는 여러 사이클에 포함될수 없다
            //  한 번 탐색한 값은 다시 탐색할 필요가 없다 (이미 사이클에 추가되었거나 사이클이 없거나)
            //  -> isVisited[i]를 false로 되돌리지 않는다.

            for(int i=1; i<arr.length; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    dfs(i, arr[i]);
                }
            }

            System.out.println(count);
        }
    }

    static void dfs(int startIdx, int nextIdx) {
        //사이클일 경우
        if (startIdx == nextIdx) {
            count++;
        }

        if (!isVisited[nextIdx]) {
            isVisited[nextIdx] = true;
            dfs(startIdx, arr[nextIdx]);
        }
    }

//
//        //test cases
//        for (int i = 0; i < T; i++) {
//            count = 0;
//            V = Integer.parseInt(br.readLine());
//            arr = new int[V + 1];
//            isVisited = new boolean[V + 1];
//
//            //input numbers
//            st = new StringTokenizer(br.readLine());
//            for (int k = 1; k <= V; k++) {
//                int input = Integer.parseInt(st.nextToken());
//                arr[k] = input;
//            }
//
//            //dfs
//            for (int p = 1; p <= V; p++) {
//                if(isVisited[p]) continue;
//
//                dfs(p);
//            }
//
//            System.out.println(count);
//        }
//    }
//
//    static void dfs(int vertex) {
//        //사이클이 있으면
//        if(isVisited[vertex]){
//            count++;
//            return;
//        }
//
//        isVisited[vertex] = true;
//        int next = arr[vertex];
//        dfs(next);
//    }
}