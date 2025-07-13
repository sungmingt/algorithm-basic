package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11721_str {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int length = input.length();

        int start = 0;

        while (true) {
            //남은 길이가 10 이하일때
            if (length - start <= 10) {
                sb.append(input.substring(start));
                break;
            }

            //남은 길이가 10 이상일때
            sb.append(input.substring(start, start + 10));
            sb.append("\n");

            start += 10;
        }

        System.out.println(sb);
    }
}
