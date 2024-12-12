package basic.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9663_backtracking {

    static int N;
    static int[] position;
    static int ways;

    public static void main(String[] args) throws IOException {
        //NxN 체스판에 N개의 퀸을 서로 떨어뜨려놓는 경우의 수.
        //재귀를 통해 퀸을 하나씩 배치한다.
        //  -> 이때, 주변에 퀸이 있는지 확인한 후 배치
        //퀸을 모두 다 썼을 경우 경우의수++, return
        //재귀 호출 후 board[i](방문여부) 는 초기화시킨다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        position = new int[N];
        //o o o o o
        //o o o o o
        //o o o o o
        //o o o o o
        //o o o o o

        //방문여부 체크가 아니라, 어차피 한 행에 하나씩밖에 못 놓기 때문에 1차원 배열로 놓은 위치를 표시한다.

        dfs(0);
        System.out.println(ways);
    }

    //퀸을 놓을때마다 공격 범위(좌우대각선 모두)를 true 처리한다.
    static void dfs(int depth) {
        //마지막 행일 경우 queen을 모두 놓은 것
        if (depth == N) {
            ways++;
            return;
        }

        for (int i = 0; i < N; i++) {
            position[depth] = i;

            //놓을 수 있는 위치일 경우 재귀호출
            if (isPossible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    static boolean isPossible(int x) {
        for (int i = 0; i < x; i++) {
            //같은 열에 퀸이 있다면
            if (position[i] == position[x]) {
                return false;
            }

            //대각선에 퀸이 있다면
            if (Math.abs(i - x) == Math.abs(position[i] - position[x])) {
                return false;
            }
        }

        return true;
    }
}
