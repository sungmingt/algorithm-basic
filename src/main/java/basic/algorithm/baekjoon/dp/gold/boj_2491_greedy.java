package basic.algorithm.baekjoon.dp.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2491_greedy {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        //input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean isIncreasing = true;
        int maxStack = 1;
        int curStack = 1;
        int sameStack = 1;

        for (int i = 1; i < arr.length; i++) {
            int prev = arr[i - 1];
            int num = arr[i];

            if (num == prev) {
                curStack++;
                maxStack = Math.max(maxStack, curStack);
                sameStack++;
                continue;
            }

            if (num > prev) {
                if (isIncreasing) {
                    curStack++;
                    maxStack = Math.max(maxStack, curStack);
                } else {
                    isIncreasing = true;
                    curStack = 1 + sameStack;
                }
            } else {
                if (!isIncreasing) {
                    curStack++;
                    maxStack = Math.max(maxStack, curStack);
                } else {
                    isIncreasing = false;
                    curStack = 1 + sameStack;
                }
            }

            sameStack = 1;
        }

        System.out.println(maxStack);
    }
}
