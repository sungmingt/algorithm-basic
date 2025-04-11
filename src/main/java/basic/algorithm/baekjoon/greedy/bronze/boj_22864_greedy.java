package basic.algorithm.baekjoon.greedy.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_22864_greedy {

    static int A, B, C, M;
    static int fatigue, worksDone;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //M이 넘지 않는 선에서 계속 일을 한다.
        //만일 한시간 더 일하면 M이 넘는 경우(if(fatigue + A > M)), 한시간 쉰다 (fatigue -= C)

        int T = 0;
        while (T < 24) {
            if (fatigue + A > M) {
                fatigue = (fatigue - C <= 0) ? 0 : fatigue - C;
            } else {
                fatigue += A;
                worksDone += B;
            }

            T++;
        }

        System.out.println(worksDone);
    }
}
