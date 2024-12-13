package basic.algorithm.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_2580_backtracking {

    static int[][] map;
    static ArrayList<int[]> blank;
    static int N = 9;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        //스도쿠
        //빈 칸을 채운다
        //채울때, 가로/세로/3x3 박스에 같은 숫자가 있으면 안된다.

        //재귀+반복문 으로 모든 경우의 수를 탐색한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        blank = new ArrayList<>();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int k = 0; k < N; k++) {
                map[i][k] = Integer.parseInt(st.nextToken());
                if (map[i][k] == 0) {
                    blank.add(new int[]{i, k});
                }
            }
        }

        //map[i][k] == 0 이면 빈칸이다. -> 입력받을때 빈칸일경우 arraylist에 해당 좌표를 추가한다.
        //재귀로 탐색한다.
        //해당 좌표의 가로/세로/정사각형 내부 를 탐색하면서 현재 입력하려는 숫자가 있는지 확인한다.
        //ex)
        // map[2][2]가 빈칸일 경우 -> map[2][0~9], map[0~9][2] 탐색

        dfs(0);
    }

    //depth : 빈 칸의 인덱스
    static void dfs(int depth) {
        if (depth == blank.size()) {
            for (int i = 0; i < N; i++) {
                for (int k = 0; k < N; k++) {
                    System.out.print(map[i][k] + " ");
                }

                System.out.println();
            }

            System.exit(0);
            return;
        }

        int[] blankPoint = blank.get(depth);

        //사용되지 않은 숫자를 찾는다
        for (int i = 1; i <= 9; i++) {
            //사용되지 않은 숫자라면
            if (isPossible(blankPoint, i)) {
                map[blankPoint[0]][blankPoint[1]] = i;
                dfs(depth + 1);
                map[blankPoint[0]][blankPoint[1]] = 0;
            }
        }
    }

    static boolean isPossible(int[] blankPoint, int value) {
        return searchLine(blankPoint, value) && searchSquare(blankPoint, value);
    }

    static boolean searchLine(int[] blankPoint, int value) {
        //빈칸 좌표의 가로/세로 탐색
        for (int i = 0; i < N; i++) {
            if(map[blankPoint[0]][i] == value) return false;
            if(map[i][blankPoint[1]] == value) return false;
        }

        return true;
    }

    static boolean searchSquare(int[] blankPoint, int value) {
        int startRow = (blankPoint[0] / 3) * 3;    // value가 속한 3x3의 행의 첫 위치
        int startCol = (blankPoint[1] / 3) * 3;    // value가 속한 3x3의 열의 첫 위치

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
