package basic.algorithm.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용액_2467_투포인터 {

    static long[] arr;
    static long minAbs = 2000000000;
    static int left, right;
    static long answer1, answer2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        right = N - 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        //투포인터
        //[-99, -2, -1, 4 98]
        //포인터 이동은, 현재 포인터 값들의 합의 음/양 여부로 결정한다.
        //  0과 가까워져야하기 때문에, left 또는 right 중 한 포인터를 옮기면 된다.
        //  오름차순 정렬이기에 가능하다.

        while (left < right) {
            long sum = arr[left] + arr[right];
            long curAbs = Math.abs(sum);

            //절대값 비교 + 초기화
            if (curAbs < minAbs) {
                minAbs = curAbs;
                answer1 = arr[left];
                answer2 = arr[right];
            }

            //포인터 이동
            if(sum < 0) left++;
            else right--;
        }

        System.out.println(answer1 + " " + answer2);
    }
}
