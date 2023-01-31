package basic.algorithm.baekjoon.이분탐색.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K번째수_이분탐색 { //다시 풀어보기 (규칙 찾기)

    public static void main(String[] args) throws IOException {
        //1 2 3
        //2 4 6
        //3 6 9
        //오름차순 -> 1, 2, 2, 3, 3, 4, 6, 6, 9

        //max : N * N
        //min : 0
        //이분 탐색의 기준(비교값) : K번째의 수
        //이분 탐색 결과값 : index(K)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long max = K;
        long min = 0;
        long mid = 0;

        while (min < max) {
            mid = (min + max) / 2;

            long bK = 0;

            //mid(임의의 요소) 보다 작거나 같은 값의 개수(K) 구하기
            for (int i = 1; i <= N; i++) {
                bK += Math.min(N, mid / i);
            }

            //임의의 수보다 작거나 같은 개수가 목표치보다 작다면 => 임의의 수를 높인다.
            if (bK < K) { //(Lower Bound)
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min);
    }
}
