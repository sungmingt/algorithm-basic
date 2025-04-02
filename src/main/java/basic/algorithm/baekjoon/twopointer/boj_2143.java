package basic.algorithm.baekjoon.twopointer;

import java.io.*;
import java.util.*;

public class boj_2143 {

    static int T, N, M;
    static long ansCnt;
    static int[] numsA, numsB, sumA, sumB, partA, partB;
    static String[] ss;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(in.readLine());
        N = Integer.parseInt(in.readLine());
        numsA = new int[N];
        sumA = new int[N + 1];

        ss = in.readLine().split(" ");

        for(int i = 0; i < N; i++) {
            numsA[i] = Integer.parseInt(ss[i]);
            sumA[i + 1] = sumA[i] + numsA[i];
        }

        int temp = 0;
        partA = new int[((N + 1) * (N)) / 2];
        for(int cnt = 1; cnt <= N; cnt++) {
            for(int st = 0; st + cnt <= N; st++) {
                partA[temp++] = sumA[st + cnt] - sumA[st];
            }
        }

        M = Integer.parseInt(in.readLine());
        numsB = new int[M];
        sumB = new int[M + 1];

        ss = in.readLine().split(" ");

        for(int i = 0; i < M; i++) {
            numsB[i] = Integer.parseInt(ss[i]);
            sumB[i + 1] = sumB[i] + numsB[i];
        }

        temp = 0;
        partB = new int[((M + 1) * (M)) / 2];
        for(int cnt = 1; cnt <= M; cnt++) {
            for(int st = 0; st + cnt <= M; st++) {
                partB[temp++] = sumB[st + cnt] - sumB[st];
            }
        }

        Arrays.sort(partA);
        Arrays.sort(partB);

        int aLeft = 0;
        int bRight = partB.length - 1;
        while(aLeft < partA.length && 0 <= bRight) {
            int aValue = partA[aLeft];
            int bValue = partB[bRight];

            if(aValue + bValue == T) {
                long aCnt = 0L;
                long bCnt = 0L;
                while(aLeft < partA.length && aValue == partA[aLeft]) {
                    aLeft++;
                    aCnt++;
                }
                while(0 <= bRight && bValue == partB[bRight]) {
                    bRight--;
                    bCnt++;
                }

                ansCnt += aCnt * bCnt;
            }
            else if(aValue + bValue < T) {
                aLeft++;
            }
            else {
                bRight--;
            }
        }

        System.out.println(ansCnt);
    }
}