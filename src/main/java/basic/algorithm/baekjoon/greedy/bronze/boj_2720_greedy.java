package basic.algorithm.baekjoon.greedy.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2720_greedy {

    static int T;
    static int[] coins = {25, 10, 5, 1};
    static int[] coinUsed;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            int change = Integer.parseInt(br.readLine());
            coinUsed = new int[4];
            int i = 0;

            while (change > 0 && i < 4) {
                if (coins[i] <= change) {
                    coinUsed[i]++;
                    change -= coins[i];
                } else {
                    i++;
                }
            }

            for (int c : coinUsed) {
                sb.append(c).append(" ");
            }

            sb.append("\n");
        }
        //25, 10, 5 동전 3개로 동전 개수를 최소화하여 거스름돈을 만들어야함.

        //25, 10, 5, 1 차례로 쓸 수 있다면 쓴다.
        //??? 앞의 동전을 썼기때문에 거스름돈을 못만드는 경우가 있나?? -> 없다

        System.out.println(sb);
    }
}
