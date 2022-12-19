package basic.algorithm.baekjoon.silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 쉽게푸는문제_1292 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        int result = 0;

        //배열 채워넣기
        for (int i = 1; i < 1001; i++) {
            for (int j = 1; j <= i; j++) {
                arr.add(i);
            }
        }

        for (int i = start - 1; i <= end - 1; i++) {
            result += arr.get(i);
        }

        System.out.println(result);
    }

}
