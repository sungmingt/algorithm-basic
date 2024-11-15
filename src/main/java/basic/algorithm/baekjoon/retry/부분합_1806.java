package basic.algorithm.baekjoon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합_1806 { //투포인터, 다시 풀어보기

    static int N, target;
    static int[] arr;
    static int curSum;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int minLength = N + 1;

        while (true) {
            //현재 target보다 크다면 -> start를 늘려가면서 최소 길이를 찾는다.
            if (curSum >= target) {
                minLength = Math.min(minLength, end - start);
                curSum -= arr[start];
                start++;
            }

            //end가 마지막이라면 break
            else if (end == N) {
                break;
            }

            //현재 target보다 작다면 -> end를 늘려가면서 target에 도달하도록 한다.
            else {
                curSum += arr[end];
                end++;
            }
        }

        if (minLength == N + 1) System.out.println(0);
        else System.out.println(minLength);
    }
}
