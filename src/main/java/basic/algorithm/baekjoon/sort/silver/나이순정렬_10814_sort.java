package basic.algorithm.baekjoon.sort.silver;

import java.util.Arrays;
import java.util.Scanner;

public class 나이순정렬_10814_sort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[][] arr = new String[N][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = String.valueOf(sc.nextInt());
            arr[i][1] = sc.next();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) {
                return 0;
            } else {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for (String[] strings : arr) {
            System.out.println(strings[0] + " " + strings[1]);
        }
    }
}
