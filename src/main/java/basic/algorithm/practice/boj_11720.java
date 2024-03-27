package basic.algorithm.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11720 {

    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String input = br.readLine();

        for (int i = 0; i < T; i++) {
            int num = input.charAt(i) - '0';
            total += num;
        }

        System.out.println(total);
    }
}
