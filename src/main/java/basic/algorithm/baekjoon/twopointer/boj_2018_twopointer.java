package basic.algorithm.baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2018_twopointer {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //포인터의 기준점은 N / 2 + 1
        //점점 감소하도록

        int std = N / 2 + 1;
        int cnt = 2;
        int answer = 1;

        while (std - cnt >= 0) {
            int curSum = 0;

            //cnt개의 숫자 합 구하기
            for (int i = 0; i < cnt; i++) {
                int val = std - i;
                curSum += val;
            }

            if (curSum == N) {
                answer++;
                std--;
                cnt++;
            } else if (curSum > N) {
                std--;
            } else {
                cnt++;
            }
        }

        System.out.println(answer);
    }
}
