package basic.algorithm.baekjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2217_greedy {

    static int N;
    static Integer[] ropes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ropes = new Integer[N];

        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes, (o1, o2) -> o2 - o1);

        //0~N개를 뽑았을때 가능한 최대 중량을 구한다.
        //즉, 차례로 뽑으면서 최대 중량을 초과할때까지 sum/i+1 을 구하고, 해당 중량을 max 값에 갱신시킨다.

        int max = ropes[0];

        for (int i = 1; i < N; i++) {
            max = Math.max(max, ropes[i] * (i + 1));
        }

        System.out.println(max);
    }
}
