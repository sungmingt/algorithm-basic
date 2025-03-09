package basic.algorithm.baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숫자카드_10815_이분탐색 {

    static int N, M;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cards = new int[N];

        //input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        //sort
        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = N - 1;
            int mid;
            boolean isContained = false;

            while (start <= end) {
                mid = (start + end) / 2;

                if (cards[mid] == num) {
                    isContained = true;
                    break;
                }

                // 1 3 6 9 13
                if (cards[mid] < num) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            if (isContained) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}


    //HashSet 풀이
//    static int N, M;
//    static Set<Integer> cards;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(br.readLine());
//        cards = new HashSet<>();
//
//        //input
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            cards.add(Integer.parseInt(st.nextToken()));
//        }
//
//        M = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < M; i++) {
//            int num = Integer.parseInt(st.nextToken());
//
//            if (cards.contains(num)) {
//                sb.append(1);
//            } else {
//                sb.append(0);
//            }
//
//            sb.append(" ");
//        }
//
//        System.out.println(sb);
//    }
