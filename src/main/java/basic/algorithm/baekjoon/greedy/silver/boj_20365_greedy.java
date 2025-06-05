package basic.algorithm.baekjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_20365_greedy {

    static int N;
    static int Bcnt, Rcnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        //정답 : (둘 중 최소 묶음 개수 + 1)

        //처음부터 count 되도록
        char prev = input.charAt(0) == 'B' ? 'R' : 'B';

        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);

            if (c == 'B') {
                if (prev == 'R') {
                    Bcnt++;
                    prev = 'B';
                }
            } else {
                if (prev == 'B') {
                    Rcnt++;
                    prev = 'R';
                }
            }
        }

        System.out.println(Math.min(Bcnt, Rcnt) + 1);
    }
}
