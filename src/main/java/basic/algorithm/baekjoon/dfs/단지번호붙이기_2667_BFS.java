package basic.algorithm.baekjoon.dfs;

import java.io.*;
import java.util.*;

public class 단지번호붙이기_2667_BFS {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> q;
    static List<Integer> aptSizes = new ArrayList<>();
    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //단지의 개수를 찾아야한다.

        //방문한 곳은 곧바로 방문처리한다.
        //단지가 시작되는 시점이라면, bfs/집 개수 카운트를 시작한다.
        //단지가 끝나는 지점, 즉 큐가 비어있다면 탐색 종료 후 집의 개수를 저장한다.

        //집의 개수는 list에 오름차순 저장.

        map = new int[N][N];
        visited = new boolean[N][N];

        //input map
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");

            for (int k = 0; k < N; k++) {
                map[i][k] = Integer.parseInt(input[k]);
            }
        }

        //bfs
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                int place = map[i][k];

                if (place == 1 && !visited[i][k]) {
                    //집이 있다면, bfs 탐색 시작
                    visited[i][k] = true;
                    bfs(i, k);
                }
            }
        }

        aptSizes.sort(Comparator.comparingInt(o -> o));

        StringBuilder sb = new StringBuilder();
        sb.append(aptSizes.size()).append("\n");

        for (int size : aptSizes) {
            sb.append(size).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Point point = new Point(x, y);
        q = new LinkedList<>();
        q.offer(point);
        int aptSize = 1;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nX = cur.x + dX[i];
                int nY = cur.y + dY[i];

                if (!isMovable(nX, nY) || visited[nX][nY] || map[nX][nY] == 0) {
                    continue;
                }

                visited[nX][nY] = true;
                q.offer(new Point(nX, nY));
                aptSize++;
            }
        }

        aptSizes.add(aptSize);
    }

    private static boolean isMovable(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//
//        map = new int[N][N];
//        visited = new boolean[N][N];
//        for (int i = 0; i < N; i++) {
//            String input = sc.next();
//
//            for (int j = 0; j < N; j++) {
//                map[i][j] = input.charAt(j) - '0';
//            }
//        }
//
//        apartmentSize = new int[N * N];
//
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[i].length; j++) {
//
//                if (map[i][j] == 1 && !visited[i][j]) {
//                    apartmentCount++;
//                    dfs(i, j);
//                }
//            }
//        }
//
//        Arrays.sort(apartmentSize);
//        System.out.println(apartmentCount);
//
//        for (int i = apartmentSize.length - apartmentCount; i < apartmentSize.length; i++) {
//            System.out.println(apartmentSize[i]);
//        }
//    }
//
//    static void dfs(int x, int y) {
//        visited[x][y] = true;
//        apartmentSize[apartmentCount]++; //현재 단지의 아파트 개수 증가
//
//        for (int i = 0; i < 4; i++) {
//            int newX = x + dX[i];
//            int newY = y + dY[i];
//
//            if (0 <= newX && newX < map.length && 0 <= newY && newY < map.length) {
//                if (map[newX][newY] == 1 && !visited[newX][newY]) {
//                    dfs(newX, newY);
//                }
//            }
//
//        }
//    }
}
