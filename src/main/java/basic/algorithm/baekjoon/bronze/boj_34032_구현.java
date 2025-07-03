package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_34032_구현 {

    static int N;
    static int ggCnt;
    static boolean isGG = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");

        for (String command : input) {
            if (command.equals("O")) {
                ggCnt++;

                //팀원 수가 짝수일때
                if (N % 2 == 0 && ggCnt >= N / 2) {
                    isGG = true;
                    break;
                }

                //팀원 수가 홀수일때
                if (N % 2 != 0 && ggCnt > N / 2) {
                    isGG = true;
                    break;
                }
            }
        }

        System.out.println(isGG ? "Yes" : "No");
    }
}
