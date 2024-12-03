package basic.algorithm.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2667_BFS {

    static int[][] map;
    static boolean[][] isVisited;
    static Queue<House> q;
    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {-1, 1, 0, 0};
    static int N;
    static int villageCount;
    static List<Integer> houseCounts;
    static int curHouseCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        isVisited = new boolean[N][N];
        houseCounts = new ArrayList<>();
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int k = 0; k < N; k++) {
                int input = s.charAt(k) - '0';
                map[i][k] = input;
            }
        }

        //단지의 수와 각 단지 집의 수를 오름차순으로 출력

        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                curHouseCount = 0;
                if (!isVisited[i][k] && map[i][k] == 1) {
                    bfs(new House(i, k));
                }
            }
        }

        Collections.sort(houseCounts);

        System.out.println(villageCount);
        for (int c : houseCounts) {
            System.out.println(c);
        }
    }

    //1. bfs로 탐색한다.
    //2. 방문한 경우 다시 탐색하지 않는다 + 집이 없는 경우 탐색하지 않는다.
    //3. map[i][k] == 1 인 경우만 탐색 후 큐에 넣는다. 그렇지 않으면 스킵
    //4. 이중 for문을 통해 모든 집에서부터 bfs 탐색을 한다.
    //5. 단지가 형성된 경우(즉, 큐에 더이상 값이 없고 curHouseCount != 0 일때) villages에 넣고 villageCount++
    //6. 이를 위해 이중 for문 시작 시 curHouseCount를 초기화해준다.

    static void bfs(House house) {
        q.offer(house);
        isVisited[house.x][house.y] = true;
        curHouseCount++;

        while (!q.isEmpty()) {
            House curHouse = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curHouse.x + dX[i];
                int nextY = curHouse.y + dY[i];

                if (isMovable(nextX, nextY) && !isVisited[nextX][nextY] && map[nextX][nextY] == 1) {
                    q.offer(new House(nextX, nextY));
                    isVisited[nextX][nextY] = true;
                    curHouseCount++;
                }
            }
        }

        houseCounts.add(curHouseCount);
        villageCount++;
    }

    static boolean isMovable(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static class House {
        int x, y;

        House(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
