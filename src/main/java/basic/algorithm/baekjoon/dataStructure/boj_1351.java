package basic.algorithm.baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_1351 {

    static long N, P, Q;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        System.out.println(solve(N));
    }

    static long solve(long num) {
        if(num == 0) return 1;
        if(map.containsKey(num)) return map.get(num);

        long a = num / P;
        long b = num / Q;

        map.put(num, solve(a)+solve(b));
        return map.get(num);
    }
}
