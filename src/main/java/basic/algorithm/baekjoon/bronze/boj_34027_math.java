package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_34027_math {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            double sqrt = Math.sqrt(N);
            if (Math.floor(sqrt) == sqrt) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
