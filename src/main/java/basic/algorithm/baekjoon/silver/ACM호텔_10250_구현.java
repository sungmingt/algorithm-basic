package basic.algorithm.baekjoon.silver;

import java.util.*;

public class ACM호텔_10250_구현 {

    static int H;
    static int W;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //H x W
        //Y 또는 YY : 높이(H)
        //X 또는 XX : 가로(W)
        //가장 인접한 방을 배정한다.
        //거리가 같다면 -> 아래층을 선호한다.

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            H = sc.nextInt();
            W = sc.nextInt();
            N = sc.nextInt();

            int width = N % H == 0 ? (N / H) : (N / H) + 1;
            int height = N % H == 0 ? 100 * H : 100 * (N % H);

            System.out.println(height + width);
        }
    }
}
class Room{
    int x;
    int y;
    int distance;

    public Room(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}