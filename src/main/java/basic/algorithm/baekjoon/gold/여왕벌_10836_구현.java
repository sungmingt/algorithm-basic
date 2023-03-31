package basic.algorithm.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 여왕벌_10836_구현 {

    static int[][] map;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        //M x M
        //하루에 0, 1, 2 만큼 자란다
        //제일 왼쪽 열[i,0]과 제일 위쪽 행[0,i]은 스스로 자라는 정도를 결정
        //나머지 놈들은 자신의 쪽(L), 왼쪽 위(D), 위쪽(U) 중 가장 큰 값만큼 자란다.
        //마지막날 애벌레들의 크기 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); //가로,세로 길이
        N = Integer.parseInt(st.nextToken()); //날짜 수
        map = new int[M][M];

        //map 초기화
        for (int i = 0; i < M; i++) {
            Arrays.fill(map[i], 1);
        }

        for (int i = 0; i < N; i++) {
            //map[M-1][0] 부터 map[0][0]까지, 그리고 map[0][M-1] 까지
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st2.nextToken());
            int one = Integer.parseInt(st2.nextToken());
            int two = Integer.parseInt(st2.nextToken());

            //첫번째 열 입력
            for (int j = M - 1; j >= 0; j--) {
                if (zero != 0) {
                    zero--;
                } else if (one != 0) {
                    map[j][0] += 1;
                    one--;
                } else if (two != 0) {
                    map[j][0] += 2;
                    two--;
                }
            }

            //첫번째 행 입력
            for (int j = 1; j < M; j++) {
                if (zero != 0) {
                    zero--;
                } else if (one != 0) {
                    map[0][j] += 1;
                    one--;
                } else if (two != 0) {
                    map[0][j] += 2;
                    two--;
                }
            }

//처음 작성한 입력구현
//            for (int k = 0; k < plusCounts.length; k++) {
//                for (int j = 0; j < plusCounts[k]; j++) {
//                    if (idx == 0) isFirst = false;
//
//                    //map[x][0]인 경우
//                    if (isFirst) {
//                        map[idx][0] += k;
//                        idx--;
//                    } else { //map[0][x]인 경우
//                        map[0][idx] += k;
//                        idx++;
//                    }
//                }
//            }
        }

        //순회 map[1,1], map[1,2] ... 부터 map[M-1, M-1]까지
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map.length; j++) {
                //왼쪽, 왼위, 위쪽 중 가장 큰 값 입력
                map[i][j] = Math.max(map[i][j - 1], Math.max(map[i - 1][j - 1], map[i - 1][j]));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) sb.append(map[i][j] + " ");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
