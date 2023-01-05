package basic.algorithm.baekjoon.greedy.silver;

import java.util.Arrays;
import java.util.Scanner;

public class ProjectTeams_20044_greedy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int memberCount = sc.nextInt() * 2;

        int[] cap = new int[memberCount];
        for (int i = 0; i < cap.length; i++) {
            cap[i] = sc.nextInt();
        }

        Arrays.sort(cap);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cap.length; i++) {
            int sum = cap[i] + cap[cap.length - 1 - i];
            if(sum < min) min = sum;
        }

        System.out.println(min);
    }
}
