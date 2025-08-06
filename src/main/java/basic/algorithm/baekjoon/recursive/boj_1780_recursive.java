package basic.algorithm.baekjoon.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1780_recursive {

    static int N;
    static int[][] arr;
    static int[] count = new int[3]; //-1,0,1 을 0,1,2로 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        //input
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int k = 0; k < N; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        //모든 요소를 탐색. 탐색 중 다른 수 나오면 쪼개기 진행
        //다른 수가 나올 경우 -> cur/3 (9등분) and 각 부분 똑같이 탐색
        //cur=1이 될때까지 진행.

        split(0, 0, N);

        for (int c : count) {
            System.out.println(c);
        }
    }

    private static void split(int fromX, int fromY, int size) {
        if (isSameNumbers(fromX, fromY, size)) {
            count[arr[fromX][fromY] + 1]++;
            return;
        }

        int nSize = size / 3;

        //27 -> 0~27
        //9 -> 0~8, 9~17, 18~26
        //3 -> 0~2, 3~5, 6~8

        //다른 값이 있는 경우 -> 쪼개기
        for (int dX = 0; dX < 3; dX++) {
            for (int dY = 0; dY < 3; dY++) {
                split(fromX + dX*nSize, fromY + dY*nSize, nSize);
            }
        }
    }

    private static boolean isSameNumbers(int fromX, int fromY, int length) {
        int value = arr[fromX][fromY];

        for (int i = fromX; i < fromX + length; i++) {
            for (int k = fromY; k < fromY + length; k++) {
                //다른 값이 있는 경우 -> break;
                if (value != arr[i][k]) {
                    return false;
                }
            }
        }

        return true;
    }
}
