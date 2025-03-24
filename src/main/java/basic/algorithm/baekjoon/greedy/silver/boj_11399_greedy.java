package basic.algorithm.baekjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11399_greedy {

    static int N;
    static int[] P;
    static int minTimeSpent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N];

        //input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        //결론적으로, 시간이 적게 걸리는 사람이 먼저 뽑아야한다.

        //sort
        Arrays.sort(P);

        int curTimeSpent = 0;
        for (int t : P) {
            curTimeSpent += t;
            minTimeSpent += curTimeSpent;
        }

        //1 3 6 9 13
        System.out.println(minTimeSpent);
    }
}
