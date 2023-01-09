package basic.algorithm.baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

public class 단어정렬_1181_sort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[] arr = new String[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }

        //1. 길이 짧은 순
        //2. 사전 순

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() - o2.length();
            }
        });

        System.out.println(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals(arr[i - 1])) {
                System.out.println(arr[i]);
            }
        }
    }
}
