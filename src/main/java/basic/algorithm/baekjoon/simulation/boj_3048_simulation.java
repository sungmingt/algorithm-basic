package basic.algorithm.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3048_simulation {

    static int N1, N2, T;
    static String[][] road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N1 = Integer.parseInt(st.nextToken());
        N2 = Integer.parseInt(st.nextToken());

        String[] input1 = br.readLine().split("");
        String[] input2 = br.readLine().split("");
        road = new String[N1 + N2][2]; //road[][]는 [알파벳, 움직이는 방향] 이다.

        //3  0 2  1 1 2 0
        for (int i = N1 - 1; i >=0; i--) {
            road[N1 - i - 1][0] = input1[i];
            road[N1 - i - 1][1] = "R"; //움직이는 방향 저장
        }

        for (int i = 0; i < N2; i++) {
            road[N1 + i][0] = input2[i];
            road[N1 + i][1] = "L"; //움직이는 방향 저장
        }

        T = Integer.parseInt(br.readLine());

        //1초마다 배열을 순회하며 개미들을 점프시킨다.
        //만일 개미의 방향이 R이고, i < road.length - 1 라면 -> 해당 개미와 오른쪽 개미의 위치를 바꿔준다.
        //이때, 현재 개미의 오른쪽 개미도 이미 점프처리가 되었기 때문에 다음 개미는 skip 후 다다음 개미를 확인한다.

        while (T > 0) {
            T--;

            String[][] temp = road.clone();

            for (int i = 0; i < road.length; i++) {
                if (road[i][1].equals("R") && i < road.length - 1) {
                    temp[i][0] = road[i + 1][0];
                    temp[i][1] = road[i + 1][1];
                    temp[i+1][0] = road[i][0];
                    temp[i+1][1] = road[i][1];

                    i++;
                }
            }

            road = temp;
        }

        for (int i = 0; i < road.length; i++) {
            System.out.print(road[i][0]);
        }
    }
}
