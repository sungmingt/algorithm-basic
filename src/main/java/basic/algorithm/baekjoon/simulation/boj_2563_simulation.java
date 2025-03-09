package basic.algorithm.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2563_simulation {

    static boolean[][] sketch = new boolean[101][101];
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int k = x; k < x + 10; k++) {
                for (int p = y; p < y + 10; p++) {

                    if (!sketch[k][p]) {
                        sketch[k][p] = true;
                        total++;
                    }
                }
            }
        }

        System.out.println(total);
    }
}
