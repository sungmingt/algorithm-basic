package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 근손실_18429_backtracking {

    static int N;
    static int K;
    static int weight = 500;
    static boolean[] visited;
    static int[] kits;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        //중량 500
        //하루에 K만큼 감소

        //중량을 증가시킬수 있는 N개의 서로 다른 키트
        //하루에 1개씩 사용
        //항상 중량이 500이상으로 유지할 수 있는 경우의 수를 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        kits = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            kits[i] = Integer.parseInt(st2.nextToken());
        }

        visited = new boolean[N];
        backtracking(0, 500);

        System.out.println(answer);
    }

    static void backtracking(int depth, int weight) {
        if (depth == N) {
            answer++;
            return;
        }

        for (int i = 0; i < kits.length; i++) {
            //방문하지 않았을 경우
            if (!visited[i]) {
                visited[i] = true;
                //500을 이상일 때만 계속 backtracking
                if (weight - K + kits[i] >= 500) {
                    backtracking(depth + 1, weight - K + kits[i]);
                }

                visited[i] = false;
            }
        }
    }
}
