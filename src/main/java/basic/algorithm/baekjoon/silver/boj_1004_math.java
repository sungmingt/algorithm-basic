package basic.algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1004_math {

    static int T;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int C = Integer.parseInt(br.readLine()); //행성계의 개수
            int count = 0;

            for (int i = 0; i < C; i++) {
                st = new StringTokenizer(br.readLine());
                int cX = Integer.parseInt(st.nextToken());
                int cY = Integer.parseInt(st.nextToken());
                int cR = Integer.parseInt(st.nextToken());

                boolean startThrough = isThrough(startX, startY, cX, cY, cR);
                boolean endThrough = isThrough(endX, endY, cX, cY, cR);

                //시작점과 끝점 모두 원안에 있으면 행성계를 거치지 않기 때문에 count 하지 않는다.
                //둘 중 하나만 행성계 안에 있어야 행성계를 거친다.
                if (startThrough != endThrough)
                    count++;
            }

            System.out.println(count);
        }
    }

    static boolean isThrough(int x0,int y0,int x1,int y1, int r) {
        return Math.sqrt(Math.pow(x0 - x1, 2) + Math.pow(y0 - y1, 2)) < r;	//시작점이 원 안에 있는지
    }
}
