package basic.algorithm.baekjoon.dataStructure.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_14425_hash {

    static int N, M;
    static Set<String> S;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            S.add(input);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (S.contains(str)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
