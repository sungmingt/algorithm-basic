package basic.algorithm.baekjoon.bfs.gold;

import java.io.*;
import java.util.*;

public class boj_9205_bfs {

    static int T, N;
    static Point[] stores;
    static boolean[] storeVisited;
    static Queue<Point> q;
    static Point sangeuni;
    static Point festival;
    static boolean isPossible;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            input();

            //어떤 편의점을 먼저 들르는게 유리할지 모르기때문에, 편의점과의 거리를 계산해서 그리디로 푸는건 불가능할것같다.
            //그러니까 bfs로 편의점들을 들르는것!!

            q.offer(sangeuni);
            bfs();

            System.out.println(isPossible ? "happy" : "sad");
        }
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Point cur = q.poll();

            //a-b로 가거나, b-다른곳 으로 가거나, 어차피 b에 도달하면 맥주가 꽉 찬다
            //-> 방문 여부를 구별할 필요 없다. (다른 노드에서 b에 도달하면 그냥 방문처리 하면 됨)

            //현재 위치에서 페스티벌까지 도착 가능한 경우
            if (isMovable(cur, festival)) {
                isPossible = true;
                break;
            }

            //다음 위치로 가능한 편의점 모두 q에 offer
            for (int i = 0; i < N; i++) {
                Point nPoint = stores[i];

                if (storeVisited[i]) {
                    continue;
                }

                //이동 가능한 편의점이라면
                if (isMovable(cur, nPoint)) {
                    q.offer(nPoint);
                    storeVisited[i] = true;
                }
            }
        }
    }

    private static boolean isMovable(Point cur, Point next) {
        return Math.abs(cur.x - next.x) + Math.abs(cur.y - next.y) <= 1000;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        q = new LinkedList<>();
        stores = new Point[N];
        storeVisited = new boolean[N];
        isPossible = false;

        //input sangeuni
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        sangeuni = new Point(x, y);

        //input stores
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            stores[i] = new Point(x, y);
        }

        //input festival location
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        festival = new Point(x, y);
    }
}
