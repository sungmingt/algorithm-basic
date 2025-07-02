package basic.algorithm.baekjoon.dataStructure.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_34033_dataStructure {

    static int N, M;
    static int cnt;
    static Map<String, Integer> standards = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //input std
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());
            standards.put(name, price);
        }

        //input deals
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());

            //정가의 105%를 초과하는지 검사
            Integer stdPrice = standards.get(name);
            if(price > stdPrice * 1.05) cnt++;
        }

        System.out.println(cnt);
    }
}
