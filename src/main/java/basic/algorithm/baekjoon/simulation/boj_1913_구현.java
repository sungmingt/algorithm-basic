package basic.algorithm.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1913_구현 {

    static int N;
    static int targetNum;
    static int[][] arr;
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {1, 0, -1, 0};
    static int num = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        //중심(시작점) : (N/2,N/2)

        //항상 다음과 같은 규칙으로 탐색
        //x--
        //depth-1 만큼 y++
        //depth 만큼 x++
        //depth 만큼 y--
        //depth 만큼 x--
        //  시작 depth : 2, 이후 2씩 증가

        //이후, 탐색이 끝인지, 더 탐색해야 하는지 찾아야 함.
        //만일 현재 좌표가 (0,0)이면 종료하면 됨.

        StringBuilder sbArr = new StringBuilder();
        StringBuilder sbTarget = new StringBuilder();

        //input target num
        targetNum = Integer.parseInt(br.readLine());

        //search
        arr[N / 2][N / 2] = 1;
        inputArr(N/2, N/2, 2);

        //print
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                int num = arr[i][k];

                sbArr.append(num).append(" ");
                if(num == targetNum) sbTarget.append(i + 1).append(" ").append(k + 1);
            }

            sbArr.append("\n");
        }

        System.out.print(sbArr);
        System.out.println(sbTarget);

    }

    private static void inputArr(int x, int y, int depth) {
        x--;
        arr[x][y] = ++num;

        //달팽이 모양으로 탐색
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                for (int k = 0; k < depth - 1; k++) {
                    x = x + dX[i];
                    y = y + dY[i];

                    arr[x][y] = ++num;
                }
            } else {
                for (int k = 0; k < depth; k++) {
                    x = x + dX[i];
                    y = y + dY[i];

                    arr[x][y] = ++num;
                }
            }
        }

        if (!(x == 0 && y == 0) && (num < N * N)) {
            inputArr(x, y, depth + 2);
        }
    }
}
