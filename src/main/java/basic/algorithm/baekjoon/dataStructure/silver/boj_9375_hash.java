package basic.algorithm.baekjoon.dataStructure.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_9375_hash {

    static Map<String, List<String>> accessories;
    static int T, N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-->0) {
            N = Integer.parseInt(br.readLine());
            accessories = new HashMap<>();
            int answer = 1;

            //input
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                String accessory = s[0];
                String category = s[1];

                if (accessories.containsKey(category)) {
                    accessories.get(category).add(accessory);
                } else {
                    accessories.put(category, new ArrayList<>());
                    accessories.get(category).add(accessory);
                }
            }

            //각 카테고리마다 각 옷을 입는 경우/안 입는 경우 가 있다.
            //ex) {hat, sunglasses} -> 3가지
            //각 카테고리별로 경우의 수를 곱하고, 마지막에 1을 빼주면 된다.

            //select
            Set<String> categories = accessories.keySet();

            for (String category : categories) {
                int size = accessories.get(category).size();
                answer *= (size + 1);
            }

            sb.append(answer - 1).append("\n");
        }

        System.out.println(sb);
    }
}
