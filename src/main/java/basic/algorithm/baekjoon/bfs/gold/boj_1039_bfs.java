package basic.algorithm.baekjoon.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1039_bfs {

    static String N;
    static int K;
    static Queue<Number> q = new LinkedList<>();
    static boolean[][] visited;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = st.nextToken();
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[1_000_001][K + 1]; //특정 숫자가 특정 depth에서 중복 교환되지 않도록

        //K번 자리를 바꿨을때 나올 수 있는 최대값

        q.offer(new Number(N, 0));
        visited[Integer.parseInt(N)][0] = true;

        //bfs -> K번 연산하기 전에 자리를 바꿀수 없다면 -1 출력
        bfs(N);

        System.out.println(answer);
    }


    private static void bfs(String num) {
        while (!q.isEmpty()) {
            Number cur = q.poll();

            if (cur.depth == K) {
                answer = Math.max(answer, Integer.parseInt(cur.value));
                continue;
            }

            for (int i = 0; i < num.length() - 1; i++) {
                for (int k = i + 1; k < num.length(); k++) {
                    StringBuilder sb = new StringBuilder(cur.value);
                    char a = sb.charAt(i);
                    char b = sb.charAt(k);
                    sb.setCharAt(i, b);
                    sb.setCharAt(k, a);

                    //첫 자리가 0이면 x
                    if (sb.charAt(0) == '0') continue;
                    int nextNum = Integer.parseInt(sb.toString());

                    if (!visited[nextNum][cur.depth + 1]) {
                        visited[nextNum][cur.depth + 1] = true;
                        q.add(new Number(sb.toString(), cur.depth + 1));
                    }
                }
            }
        }
    }

    private static class Number {
        String value;
        int depth;

        Number(String value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }
}
