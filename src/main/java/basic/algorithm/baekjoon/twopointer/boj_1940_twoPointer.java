package basic.algorithm.baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1940_twoPointer {

    static int N, M;
    static int[] materials;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        materials = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }

        //모두 자연수
        //고유한 번호 -> 겹치지 않음

        //sort
        Arrays.sort(materials);

        int start = 0;
        int end = materials.length - 1;

        while (start < end) {
            int sum = materials[start] + materials[end];

            if (sum == M) {
                answer++;
                start++;
                end--;
            } else if (sum < M) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(answer);
    }
}
