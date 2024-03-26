package basic.algorithm.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9086 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int first = 0;
            int last = str.length() - 1;
            System.out.println("" + str.charAt(first) + str.charAt(last));
        }
    }
}
