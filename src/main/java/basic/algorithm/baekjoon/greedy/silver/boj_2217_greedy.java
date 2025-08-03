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
        //현재 선택한 로프들로 만들수 있는 최대 중량 = 로프들 중 최솟값 * 선택한 로프의 개수이다.
        //따라서, 최대 중량이 큰것부터 차례로 고르면서 만들 수 있는 최대 중량을 갱신시켜주면 된다.

        int max = ropes[0];

        for (int i = 1; i < N; i++) {
            max = Math.max(max, ropes[i] * (i + 1));
        }

        System.out.println(max);
    }
}
