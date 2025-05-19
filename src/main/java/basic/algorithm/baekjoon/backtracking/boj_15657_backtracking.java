package basic.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15657_backtracking {

    static int N, M;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[N];

        //input
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //sort
        Arrays.sort(arr);

        //dfs
        dfs(0, 0);

        System.out.println(sb);
    }

    //dfs를 통해 탐색한다.
    //depth가 M일 경우 출력 후 return;

    //depth가 마지막에 도달할 경우, idx를 올려 값을 올려준다.
    //만일 idx가 더이상 올라가지 않는 경우, 탐색 depth를 줄인다.
    //  ex) 1 2 3 4,  1 1 1 4 에 도달하면 -> 4번째 값에서 3번째 값으로 탐색 depth를 줄임 -> 1 1 2 3

    public static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            result[depth] = arr[i];
            dfs(depth + 1, i); // i부터 시작하므로 중복 허용 + 비내림차순
        }
    }
}
