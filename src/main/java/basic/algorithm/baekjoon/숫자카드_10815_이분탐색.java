package basic.algorithm.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 숫자카드_10815_이분탐색 { //다시 풀어보기
    //가지고 있다 : 1
    //없다 : 0
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //가지고 있는 숫자 개수

        int[] ownCards = new int[N];
        for (int i = 0; i < N; i++) {
            ownCards[i] = sc.nextInt();
        }

        //이분 탐색을 위해서는 배열이 정렬되어 있어야 한다.
        Arrays.sort(ownCards);

        // {-10, 2, 3, 6, 8, 10}
        // input = 7
        //mid = 6, left = -10, right = 10
        //mid = 8, left = 6, right = 10
        //mid = 6, left = 6, right = 8
        //input = 10
        //mid = 6, left = -10, right = 10
        //mid = 8  left = 6, right = 10
        //mid = 8, left = 8, right = 10
        //mid =
        int mid = ownCards.length / 2;
        int left = 0;
        int right = ownCards.length - 1;

        int M = sc.nextInt(); //입력 받을 카드 개수
        for (int i = 0; i < M; i++) {
            int input = sc.nextInt();

            while (left <= right) {

                if (ownCards[mid] == input) { //같은 숫자를 찾은 경우
                    sb.append(1 + " ");
                    break;
                }else if (ownCards[mid] > input){ //중간 값이 더 클때 -> 중간값 이상의 값은 모두 제외
                    right = mid - 1;
                } else if (ownCards[mid] < input) {
                    left = mid + 1;
                }

                mid = (left + right) / 2;
            }

            sb.append(0 + " ");

            mid = ownCards.length / 2;
            left = 0;
            right = ownCards.length - 1;
        }


//        int[] result = new int[inputList.length];
//        for (int i = 0; i < inputList.length; i++) {
//            int ownCard = ownCards[i];
//
//            if (inputList[mid] == ownCard) { //같은 숫자를 찾은 경우
//                result[i]
//
//            }
//            if (inputList[mid] > ownCard) //중간 값이 더 클때 -> 중간값 이상의 값은 모두 제외
//
//        }

        System.out.println(sb);


    }
}
