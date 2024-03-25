package basic.algorithm.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int X = Integer.parseInt(split[1]);

        String[] arr = br.readLine().split(" ");

        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            if (num < X) {
                System.out.print(num);

                if (i < arr.length - 1) {
                    System.out.print(" ");
                }
            }
        }
    }
}