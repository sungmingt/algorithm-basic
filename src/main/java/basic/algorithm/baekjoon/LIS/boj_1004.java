package basic.algorithm.baekjoon.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1004 {

    static int T;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());//테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            int count = 0;
            String[] str = br.readLine().split(" ");
            int startX = Integer.parseInt(str[0]);
            int startY = Integer.parseInt(str[1]);
            int endX = Integer.parseInt(str[2]);
            int endY = Integer.parseInt(str[3]);

            int C = Integer.parseInt(br.readLine()); //행성계의 개수
            for (int i = 0; i < C; i++) {
                String[] cstr = br.readLine().split(" ");
                int cX = Integer.parseInt(cstr[0]);
                int cY = Integer.parseInt(cstr[1]);
                int cR = Integer.parseInt(cstr[2]);

                boolean startThrough = through(startX, startY, cX, cY, cR);
                boolean endThrough = through(endX, endY, cX, cY, cR);

                //시작점과 끝점 모두 원안에 함께 있지 않고 하나만 안에 있거나
                if (!(startThrough && endThrough) && (startThrough || endThrough))
                    count++;
            }
            System.out.println(count);
        }

    }

    static boolean through(int x0,int y0,int x1,int y1, int r) {
        return Math.sqrt(Math.pow(x0 - x1, 2) + Math.pow(y0 - y1, 2)) < r;	//시작점이 원 안에 있는지
    }
}
