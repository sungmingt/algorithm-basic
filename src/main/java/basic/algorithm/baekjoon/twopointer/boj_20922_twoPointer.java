package basic.algorithm.baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_20922_twoPointer {

    static int N, K;
    static int[] arr;
    static int[] numbers = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        //input
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //10 1
        //1 2 3 4 5 6 3 7 8 9

        //투포인터
        //처음부터 오른쪽 포인터(hi)를 차례로 옮기며 누적 길이를 차례로 저장하다가, 조건이 깨지는 시점에 아래의 처리를 해준다.
        //왼쪽 포인터(lo)를 조건이 다시 충족될때까지 하나씩 옮긴다.
        //조건이 다시 충족된다면 다시 오른쪽 포인터(hi)를 이동시킨다.
        //break 시점 : hi가 끝까지 도달했을때

        int maxLength = 1;
        int lo = 0;
        int hi = 0;

        while (hi < N) {
            int num = arr[hi];
            numbers[num]++;

            //조건이 깨진다면 -> 조건을 다시 충족시킬때까지, 즉 똑같은 수가 다시 나올때까지 lo를 차례로 옮긴다.
            while (numbers[num] > K) {
                numbers[arr[lo]]--;
                lo++;
            }

            maxLength = Math.max(maxLength, hi - lo + 1);
            hi++;
        }

        System.out.println(maxLength);
    }
}
