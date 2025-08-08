package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11328 {

    static int N;
    static int[] alphabets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            String fir = input[0];
            String sec = input[1];

            alphabets = new int[26];

            for (int i = 0; i < fir.length(); i++) {
                char c = fir.charAt(i);
                alphabets[c - 97]++;
            }

            for (int i = 0; i < sec.length(); i++) {
                char c = sec.charAt(i);
                alphabets[c - 97]--;
            }

            boolean isPossible = true;

            for (int a : alphabets) {
                if (a != 0) {
                    isPossible = false;
                    break;
                }
            }

            sb.append(isPossible ? "Possible" : "Impossible").append("\n");
        }

        System.out.println(sb);
    }
}
