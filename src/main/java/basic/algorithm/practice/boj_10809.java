package basic.algorithm.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_10809 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] alphabets = new int[26];
        Arrays.fill(alphabets, -1);

        for (int i=0; i<input.length(); i++) {
            int spot = input.charAt(i) - 97;
            if (alphabets[spot] == -1) {
                alphabets[spot] = i;
            }
        }

        for (int alphabet : alphabets) {
            System.out.print(alphabet);
        }
    }
}
