package basic.algorithm.baekjoon;

import java.util.Scanner;

public class 걷기_1459 {

    public static void main(String[] args) {
        // (0,0)에서 (2,0)으로 이동 시, 대각선이 소요 시간이 더 짧을 경우 대각선 두번으로 이동할 수 있는 예외 케이스 고려

        //(0,0)에서 출발
        //집의 위치 X Y
        //한 블록 소요시간 : W
        //대각선 소요시간 : S
        //최소 시간을 구해라

        //. . . .
        //. . . .

        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int W = sc.nextInt();
        int S = sc.nextInt();

        long time = 0;
        int curX = 0;
        int curY = 0;

        if (X == 0 && Y == 0) {
            System.out.println(0);
            return;
        }

        while (curX != X || curY != Y) { //좌표에 도달할때까지 반복

            if (curX < X && curY < Y) { //대각선 이동이 가능할 때
                if (S < W * 2) {  //대각선 이동이 효율적일 때
                    time += S; //시간 소요
                    curX += 1; //X 이동
                    curY += 1; //Y 이동
                    continue;
                }
            } else if (curX +2 <= X && curY == Y) { //X'만' 2 이상 떨어져 있고, 대각선 이동이 효율적일 때
                if (S < W) { //대각선 이동이 효율적일 때
                    time += S * 2; //대각선 두 번 이동
                    curX += 2; //X 2 이동
                    continue;
                }

            } else if (curY + 2 <= Y && curX == X) { //Y'만' 2 이상 떨어져 있고, 대각선 이동이 효율적일 때
                if (S < W) {
                    time += S * 2; //대각선 두 번 이동
                    curY += 2; //Y 2 이동
                    continue;
                }
            }

            //대각선 이동할 필요 없을 때
            if (curX < X) {
                time += W;
                curX += 1;
                continue;
            }

            if(curY < Y){
                time += W;
                curY += 1;
            }
        }

        System.out.println(time);
    }
}
