package basic.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14888_backtracking { //retry

    static int[] operator;
    static int[] numbers;
    static int N;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        //차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다.
        //최대값과 최소값 구하기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operator = new int[4];

        //input numbers
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        //input operator counts
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(numbers[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void dfs(int num, int idx) {
        //마지막 숫자에 도달할 경우
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        //반복문으로 모든 연산자 사용 경우를 탐색한다.
        for (int i = 0; i < 4; i++) {

            //해당 연산자의 카운트가 남아있어야 사용할 수 있다.
            if (operator[i] > 0) {
                operator[i]--; //연산자 사용

                switch (i) {
                    case 0 : dfs(num + numbers[idx], idx + 1); break;
                    case 1 : dfs(num - numbers[idx], idx + 1); break;
                    case 2 : dfs(num * numbers[idx], idx + 1); break;
                    case 3 : dfs(num / numbers[idx], idx + 1); break;
                }

                operator[i]++;
            }
        }
    }
}
