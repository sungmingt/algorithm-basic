package basic.algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2749_pisano {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pisano = 1500000;

        long n = Long.parseLong(reader.readLine());
        long index = n % pisano;

        long[] arr = new long[(int) index + 1];

        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= index; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000;
        }

        System.out.println(arr[(int) index]);
    }
}
