package basic.algorithm.baekjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_20300_greedy {

    static int N;
    static long[] muscleLoss;
    static long minLoss;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        muscleLoss = new long[N];

        //input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            muscleLoss[i] = Long.parseLong(st.nextToken());
        }

        //2개를 선택했을때, 2개의 근손실의 합의 최소값

        //짝수일때 : 양 끝 값을 차례로 더해주면 된다.
        //홀수일때 : 마지막(제일큰) 값을 1개로 두어야 한다. -> 이게 최소값
        // ex) N = 5 일때, arr[4]를 1개로 두면, 예를 들어 arr[0]+arr[3]와 arr[4]를 비교하게 된다.
        //     다른 값을 1개로 둘 경우, 결국 arr[4]와 다른 값을 더한 값이 계산에 포함된다 -> 초과

        //sort
        Arrays.sort(muscleLoss);

        //홀수일 경우, 마지막 값을 단독으로 쓴다.
        if (N % 2 == 1) {
            minLoss = muscleLoss[N - 1];
            N--;
        }

        for (int i = 0; i < N / 2 - 1; i++) {
            long sum = muscleLoss[i] + muscleLoss[N - i - 1];
            minLoss = Math.max(minLoss, sum);
        }

        System.out.println(minLoss);
    }
}
