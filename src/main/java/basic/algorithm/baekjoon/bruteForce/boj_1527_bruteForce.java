package basic.algorithm.baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1527_bruteForce {

    static int min, max;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        min = Integer.parseInt(s[0]);
        max = Integer.parseInt(s[1]);

        findKeum(0);

        System.out.println(result);
    }

    static void findKeum(long num) {
        if (num > max) {
            return;
        } else if(num >= min) {
            result++;
        }

        findKeum(num * 10 + 4);
        findKeum(num * 10 + 7);
    }
}
