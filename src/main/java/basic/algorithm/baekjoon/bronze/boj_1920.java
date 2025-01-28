package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_1920 {

    static int N, M;
    static StringTokenizer st;
    static HashSet<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new HashSet<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr.add(input);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(arr.contains(num)) System.out.println(1);
            else System.out.println(0);
        }
    }
}
