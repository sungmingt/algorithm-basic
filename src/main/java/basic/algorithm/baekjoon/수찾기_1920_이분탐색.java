package basic.algorithm.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 수찾기_1920_이분탐색 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] has = new int[N]; //가지고 있는 카드
        for (int i = 0; i < has.length; i++) {
            has[i] = sc.nextInt();
        }

        //이분 탐색을 위해 정렬
        Arrays.sort(has);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int input = sc.nextInt(); //input을 가지고 있는지 확인해야 한다.

            int start = 0;
            int end = has.length - 1;
            int mid = (start + end) / 2;
            int answer = 0;

            //{1, 2, 4, 5, 6}  찾는 숫자 : 3
            //start : 1, end : 6, mid : 4
            //start : 1, end : 2, mid : 1
            //start : 2, end : 2, mid : 2
            //start : 3, end : 2, mid : 2   -> 아웃
            while(start <= end){

                if(input == has[mid]){
                    answer = 1;
                    break;
                } else if (input < has[mid]) {
                    end = mid - 1;
                    mid = (start + end) / 2;
                } else {
                    start = mid + 1;
                    mid = (start + end) / 2;
                }
            }
            //{1,2,3,4,5}
            //4, 5, 4
            //5, 5, 5
            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }
}
