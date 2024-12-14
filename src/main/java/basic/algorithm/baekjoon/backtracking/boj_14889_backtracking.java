package basic.algorithm.baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class boj_14889_backtracking {

    static int[][] stats;
    static boolean[] visited;
    static int N;
    static int teamStartSum;
    static Stack<Integer> history;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        //팀1과 팀2의 능력치 차이를 최솟값 출력
        //N = 4 일때, 각 팀 멤버는 2명씩이며, 팀 능력치는 각각 S[0][1] + S[1][0], S[2][3] + S[3][2] 처럼 이루어진다.
        //N = 10 일때, 각 팀 멤버는 5명씩이며, 팀 능력치는 각각 01+10 02+20 0330 ...

        //풀이 방법
        //1. 팀을 어떻게 나누면서 재귀할지
        //2. 팀을 나누고 각 멤버를 어디에 저장하고 어떻게 탐색할지

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stats = new int[N][N];
        visited = new boolean[N];
        history = new Stack<>();

        //input
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int k = 0; k < N; k++) {
                stats[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        //N = 6 일때,
        // 1 2 3 4 5 6
        //팀을 나누는 경우의 수 -> 10가지
        // -> 123/456, 124/356, 125/346, 126/345, 134/256, 135/246, 136/245, 145/236, 146/235, 156/234
        // 이렇게 하는거 아닌거같다,,

            //헹 단위로 탐색
            //0 1 탐색 -> 나머지 2345 탐색가능 -> 재귀
            //0 1 2 -> 3개 찼기 때문에 나머지 345 탐색 불가능 -> 012와 345 합 비교

            //N/2개 모두 탐색했는지는 depth로 확인한다.

        visited[0] = true;
        history.push(0);
        dfs(0, 0);

        System.out.println(minValue);
    }

    static void dfs(int depth, int idx) {
        if (depth == N / 2 - 1) {
            int teamLinkSum = 0;

            for (int i = 0; i < N - 1; i++) {
                if (!visited[i]) {
                    for (int k = i + 1; k < N; k++) {
                        if (!visited[k]) {
                            teamLinkSum += stats[i][k];
                            teamLinkSum += stats[k][i];
                        }
                    }
                }
            }

            minValue = Math.min(minValue, Math.abs(teamStartSum - teamLinkSum));
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {

                int tempTeamStartSum = teamStartSum;

                for (int k = 0; k < history.size(); k++) {
                    Integer historyIdx = history.get(k);
                    teamStartSum += stats[i][historyIdx];
                    teamStartSum += stats[historyIdx][i];
                }

                visited[i] = true;
                history.push(i);

                dfs(depth + 1, i + 1);

                teamStartSum = tempTeamStartSum;
                history.pop();
                visited[i] = false;
            }
        }
    }
}
