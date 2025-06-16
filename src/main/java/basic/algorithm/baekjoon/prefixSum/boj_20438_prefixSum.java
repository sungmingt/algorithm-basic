package basic.algorithm.baekjoon.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20438_prefixSum {

    static int N, K, Q, M;
    static boolean[] isSleeping;
    static boolean[] attendance;
    static int[] prefix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isSleeping = new boolean[N + 3];
        attendance = new boolean[N + 3];
        prefix = new int[N + 3];

        //Q를 순회하며 출석 코드를 보낸다.
        //  이때, K에 포함되어 있다면 코드를 보내지 않는다.
        //  포함되어 있지 않다면 배수만큼 재귀
        //마지막에는 주어진 범위의 개수만큼 순회하며 출석되지 않은 학생 수를 출력

        //input K
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int sleepingIdx = Integer.parseInt(st.nextToken());
            isSleeping[sleepingIdx] = true;
        }

        //input Q
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int student = Integer.parseInt(st.nextToken());

            if (!isSleeping[student]) {
                sendAttendanceCode(student);
            }
        }

        //누적합 만들기
        for (int i = 3; i <= N + 2; i++) {
            prefix[i] = prefix[i - 1] + (attendance[i] ? 0 : 1);
        }

        //print
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            int unAttendedCount = prefix[to] - prefix[from - 1];
            sb.append(unAttendedCount);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void sendAttendanceCode(int idx) {
        int m = 1;

        while (idx * m <= N + 2) {
            int nIdx = idx * m;
            if (!isSleeping[nIdx]) {
                attendance[nIdx] = true;
            }

            m++;
        }
    }
}
