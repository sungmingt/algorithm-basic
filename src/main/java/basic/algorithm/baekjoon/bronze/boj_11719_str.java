package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11719_str {

    static StringBuilder sb = new StringBuilder();
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while ((input = br.readLine()) != null) {
            sb.append(input);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
