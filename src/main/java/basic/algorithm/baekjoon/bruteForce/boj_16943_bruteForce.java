package basic.algorithm.baekjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_16943_bruteForce {

    static String A, B;
    static int maxC = -1;
    static String curC = "";
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        A = s[0];
        B = s[1];
        visited = new boolean[A.length()];

        //A의 길이가 더 길면 B보다 작은 수를 만들 수 없다.
        if(A.length() > B.length()){
            System.out.println(-1);
            return;
        }

        //A의 순열을 바꿔서 B보다 작은 수 중 가장 큰 수를 만든다.
        //첫번째는 0 불가능
        //없으면 -1 출력

        dfs();

        System.out.println(maxC);
    }

    static void dfs() {
        if (curC.length() == A.length()) {
            if (Integer.parseInt(curC) < Integer.parseInt(B))
                maxC = Math.max(maxC, Integer.parseInt(curC));

            return;
        }

        for (int i = 0; i < A.length(); i++) {
            if ((curC.length() == 0 && A.charAt(i) == '0') || visited[i]) {
                continue;
            }

            visited[i] = true;
            curC += A.charAt(i);

            dfs();

            visited[i] = false;
            curC = curC.substring(0, curC.length() - 1);
        }
    }
}
