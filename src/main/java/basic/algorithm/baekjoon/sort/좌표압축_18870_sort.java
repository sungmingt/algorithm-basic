package basic.algorithm.baekjoon.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 좌표압축_18870_sort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] ordered = new int[N];
        for (int i = 0; i < ordered.length; i++) {
            ordered[i] = sc.nextInt();
        }

        int[] original = Arrays.copyOf(ordered, ordered.length);
        Arrays.sort(ordered);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < ordered.length; i++) {
            if (!rankMap.containsKey(ordered[i])) {
                rankMap.put(ordered[i], rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < original.length; i++) {
            sb.append(rankMap.get(original[i]) + " ");
        }

        System.out.println(sb);
    }
}
