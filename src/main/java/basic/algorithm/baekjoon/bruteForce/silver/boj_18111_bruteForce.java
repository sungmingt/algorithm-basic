package basic.algorithm.baekjoon.bruteForce.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_18111_bruteForce {

    static int N, M, B;
    static int[][] map;
    static int minHeight = Integer.MAX_VALUE;
    static int maxHeight = -1;
    static int minTimeSpent = Integer.MAX_VALUE;
    static int answerHeight = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        //input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int k = 0; k < M; k++) {
                int h = Integer.parseInt(st.nextToken());
                map[i][k] = h;
                minHeight = Math.min(minHeight, h);
                maxHeight = Math.max(maxHeight, h);
            }
        }

        int stdHeight = minHeight;

        while (stdHeight <= maxHeight) {
            //각 경우마다 블록을 쓰는 방법이 다르기 때문에 지역변수 사용
            int blockLeft = B;
            int timeSpent = 0;

            for (int i = 0; i < N; i++) {
                for (int k = 0; k < M; k++) {
                    int height = map[i][k];

                    if (height == stdHeight) {
                        continue;
                    }

                    if (height < stdHeight) { //블록 쌓기
                        blockLeft -= stdHeight - height;
                        timeSpent += stdHeight - height;
                    } else { //블록 제거 + 인벤토리 추가
                        blockLeft += height - stdHeight;
                        timeSpent += (height - stdHeight) * 2;
                    }
                }
            }

            //땅 고르기 작업이 끝났을때, 블록이 음수일 경우 -> 더 높은 높이는 불가능하기 때문에 break
            if (blockLeft < 0) break;

            updateAnswer(stdHeight, timeSpent);
            stdHeight++;
        }

        System.out.println(minTimeSpent + " " + answerHeight);
    }

    private static void updateAnswer(int stdHeight, int timeSpent) {
        if (timeSpent == minTimeSpent) {
            answerHeight = Math.max(answerHeight, stdHeight);
        } else if (timeSpent < minTimeSpent) {
            minTimeSpent = timeSpent;
            answerHeight = stdHeight;
        }
    }
}
