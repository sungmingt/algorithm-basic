package basic.algorithm.baekjoon.sort;

import java.util.Scanner;

public class 수정렬하기3_10989_countingSort { //마저 풀이

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        int[] A = new int[N];
        int[] B = new int[N];
        int max = 0;

        //1. 숫자를 A 배열에 입력 받는다.
        //2. A 배열을 순회하며 해당 숫자를 sum 배열의 해당 인덱스에 넣고, 1을 추가해준다.
        //3. sum 배열 처음부터 순회하며 누적 값을 다음 인덱스에 더해준다.
        //4. A 배열의 뒤에서부터 순회하며 값이 1일 경우 sum[1]의 값을 인덱스 삼아 B[sum[1]]에 해당 A 배열의 값을 넣는다
        //5. 그 후 sum의 해당 값은 -1 해준다. 그래야 다음 인덱스가 오기 때문.

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            max = Math.max(max, A[i]);

        }

        int[] sum = new int[max + 1];

        for (int i = 0; i < N; i++) {
            sum[A[i]]++;
        }

        for (int i = 1; i < N; i++) {
            sum[i] += sum[i-1];
        }

        for (int i = A.length - 1; i >= 0; i--) {
            B[--sum[A[i]]] = A[i];
        }

        for (int num : B) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }

}
