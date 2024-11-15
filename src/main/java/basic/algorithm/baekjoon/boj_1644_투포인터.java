package basic.algorithm.baekjoon;

import java.util.Scanner;

public class boj_1644_투포인터 {

    static int N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        int idx = 0;

        if(N == 1){
            System.out.println(0);
            return;
        }

        //N보다 작은 소수들을 먼저 구하여 배열을 만든다.
        for (int i = 2; i <= N; i++) {
            if(prime(i)){
                arr[idx] = i;
                idx++;
            }
        }

        int start = 0;
        int end = 0;
        int curSum = 0;
        int result = 0;

        //소수 배열을 투포인터로 순회하며 연속된 소수들로 해당 수를 만들 수 있는지 탐색한다.
        while (true) {
            if (end == N || (arr[end] == 0 && arr[end - 1] == 0)) {
                break;
            }

            if (curSum == N) {
                result++;
                curSum -= arr[start++];
                curSum += arr[end++];
            } else if (curSum < N) {
                curSum += arr[end++];
            } else {
                curSum -= arr[start++];
            }
        }

        System.out.println(result);
    }

    static boolean prime(int num) {
        if (num < 2) // 0과 1은 소수가 아님
            return false;
        else if (num == 2) {  // 2는 소수
            return true;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) // 소수가 아닐 경우
                return false;
        }

        return true;
    }
}
