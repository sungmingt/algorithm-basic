package basic.algorithm.baekjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_19941_greedy {

    static int N, K;
    static String[] line;
    static int cnt;
    static int lastLo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        line = br.readLine().split("");

        //사람이 나올때마다 탐색.
        //사람의 위치 기준 K만큼 탐색하며 가장 왼쪽의 햄버거를 먹어야 함.
        //먹었다면 H를 다른 값으로 바꿔준다.

        for (int i = 0; i < line.length; i++) {
            if (line[i].equals("P")) {
                searchHamburger(i);
            }
        }

        System.out.println(cnt);
    }

    private static void searchHamburger(int i) {
        int start = Math.max(i - K, lastLo);
        int end = Math.min(i + K + 1, N);

        for (int m = start; m < end; m++) {
            if (line[m].equals("H")) {
                cnt++;
                line[m] = "X";
                lastLo = m + 1;
                return;
            }
        }

        lastLo = end;
    }
}
