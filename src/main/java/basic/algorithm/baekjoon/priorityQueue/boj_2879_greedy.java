package basic.algorithm.baekjoon.priorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2879_greedy {

    static int N;
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int prev = 0; //diff[i-1]

        for (int i = 0; i < N; i++) {
            int cur = B[i] - A[i];

            //부호가 같을 때
            if ((prev > 0 && cur > 0) || (prev < 0 && cur < 0)) {
                answer += Math.max(0, Math.abs(cur) - Math.abs(prev));
            }
            //부호가 다를 때 (또는 prev == 0)
            else {
                answer += Math.abs(cur);
            }

            prev = cur;
        }

        System.out.println(answer);
    }
}
