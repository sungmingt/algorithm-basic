package basic.algorithm.baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17393_이분탐색 {

    static int N;
    static long[] ink;
    static long[] viscosity;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ink = new long[N];
        viscosity = new long[N];
        answer = new int[N];

        //input ink
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ink[i] = Long.parseLong(st.nextToken());
        }

        //input viscosity
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            viscosity[i] = Long.parseLong(st.nextToken());
        }

        //현재 위치보다 오른쪽에 있으면서 점도 지수가 현재 칸의 잉크지수 이하인 칸을 칠할 수 있다.
        //  각 칸의 잉크지수 Ai 는 점도지수 Bi 이상
        //  점도지수 Bi 는 항상 오름차순
        //각 타일에서 서 있을 때 칠할 수 있는 최대의 칸 수를 구하기.

        //1. 각 타일의 idx를 반복문으로 순회
        //2. 각 타일마다 칠할수 있는 칸의 개수를 이분 탐색한다.
        //  lo = idx + 1, hi = N - 1
        //  현재 잉크지수보다 크다면 불가능, 가능하다면 기록 후 추가탐색
        //  이분 탐색이 끝났을때의 max - i 가 칠할수 있는 칸 수이다.

        //이분 탐색
        for (int i = 0; i < N - 1; i++) {
            long inkValue = ink[i];
            int lo = i + 1;
            int hi = N - 1;

            int max = i;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;

                long viscosityValue = viscosity[mid];

                if (inkValue < viscosityValue) {
                    hi = mid - 1;
                } else {
                    max = mid;
                    lo = mid + 1;
                }
            }

            answer[i] = max - i;
        }

        StringBuilder sb = new StringBuilder();
        for (int a : answer) {
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }
}
