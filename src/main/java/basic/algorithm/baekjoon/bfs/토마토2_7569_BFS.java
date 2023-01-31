package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토2_7569_BFS {

    static int[][][] arr;
    static Queue<Tomato> q;
    static int[][][] visited;
    static int doneCount;
    static int[] dH = {0, 0, 0, 0, -1, 1};
    static int[] dX = {-1, 1, 0, 0, 0, 0};
    static int[] dY = {0, 0, -1, 1, 0, 0};
    static int N;
    static int M;
    static int H;

    public static void main(String[] args) throws IOException {
        //위, 아래, 왼, 오, 앞, 뒤 6가지 방향으로 영향
        //며칠이 지나면 모두 익는지 최소일수

        //출력
        //1. 모두 익어있다 -> 0
        //2. 모두 익지 못한다 -> -1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); //세로
        N = Integer.parseInt(st.nextToken()); //가로
        H = Integer.parseInt(st.nextToken()); //높이

        //1:익음, 0:안익음, -1:토마토없음
        arr = new int[H][N][M];
        q = new LinkedList<>();
        visited = new int[H][N][M];

        //배열 입력
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());

                for (int k = 0; k < M; k++) {
                    Integer value = Integer.valueOf(st2.nextToken());
                    arr[i][j][k] = value;

                    //익은 토마토이면
                    if (value == 1) {
                        q.offer(new Tomato(i, j, k));
                        visited[i][j][k] = 1;
                        doneCount++;
                    } else if (value == -1) {
                        doneCount++;
                    }
                }
            }
        }

        //BFS
        //이동가능 -> BFS visit 수행
        while (!q.isEmpty()) {
            Tomato tomato = q.poll();
            int curH = tomato.h;
            int curX = tomato.x;
            int curY = tomato.y;

            //높이/가로/세로 이동
            for (int i = 0; i < 6; i++) {
                int newH = curH + dH[i];
                int newX = curX + dX[i];
                int newY = curY + dY[i];

                //이동 가능한 경우
                if (canMove(newH, newX, newY)) {
                    //방문 안 한 경우
                    if (visited[newH][newX][newY] == 0) {
                        //안 익었을 경우
                        if (arr[newH][newX][newY] == 0) {
                            visited[newH][newX][newY] = visited[curH][curX][curY] + 1;
                            q.offer(new Tomato(newH, newX, newY));
                            doneCount++;

                            //모두 익으면
                            if (doneCount == N * M * H) {
                                System.out.println(visited[newH][newX][newY] - 1);
                                return;
                            }
                        }
                    }
                }
            }
        }

        //다 익지 못하면
        System.out.println(-1);
    }

    static boolean canMove(int newH, int newX, int newY) {
        return 0 <= newH && newH < H && 0 <= newX && newX < N && 0 <= newY && newY < M;
    }
}
class Tomato{
    int h;
    int x;
    int y;

    Tomato(int h, int x, int y) {
        this.h = h;
        this.x = x;
        this.y = y;
    }
}
