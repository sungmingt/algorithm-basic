package basic.algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 카드_11652_Hash {

    static Map<Long, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        long maxNumber = Long.MAX_VALUE;
        int maxCount = 0;

        for (int t = 0; t < N; t++) {
            long num = Long.parseLong(br.readLine());
            int count = map.getOrDefault(num, 0) + 1;

            if (count == maxCount) {
                maxNumber = Math.min(maxNumber, num);
            } else if (count > maxCount) {
                maxNumber = num;
                maxCount = count;
            }

            map.put(num, count);
        }

        System.out.println(maxNumber);
    }
}
