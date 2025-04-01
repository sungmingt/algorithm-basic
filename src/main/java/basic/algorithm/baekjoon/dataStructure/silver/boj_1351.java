package basic.algorithm.baekjoon.dataStructure.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_1351 {

    static long N, P, Q;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        //A0 = 1
        //Ai = A⌊i/P⌋ + A⌊i/Q⌋ (i ≥ 1)

        map.put(0L, 1L);
        find(N);
        System.out.println(map.get(N));
    }

    public static long find(long n) {
        if (map.containsKey(n)) return map.get(n);
        long first = find((long) Math.floor(n / P));
        long second = find((long) Math.floor(n / P));
        map.put(n, first + second);
        return first + second;
    }
}
