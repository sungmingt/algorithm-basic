package basic.algorithm.baekjoon.backtracking.gold;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15686_backtracking {

    static int N, M;
    static int[][] city;
    static boolean[] isOpenedChicken;
    static List<Point> houses;
    static List<Point> chickens;
    static int minTotalDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        minTotalDistance = Integer.MAX_VALUE;

        //빈칸(0) / 집(1) / 치킨집(2)
        //NxN, 좌표는 1부터 시작

        //치킨 거리 : 집과 가장 가까운 치킨집 사이의 거리
        //도시의 치킨 거리 : 모든 집의 치킨 거리의 합

        // -> 도시의 치킨거리가 최소가 되도록 하는 M개의 치킨집을 구해라

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int p = 0; p < N; p++) {
                city[i][p] = Integer.parseInt(st.nextToken());

                if (city[i][p] == 1) {
                    houses.add(new Point(i, p));
                } else if (city[i][p] == 2) {
                    chickens.add(new Point(i, p));
                }
            }
        }

        isOpenedChicken = new boolean[chickens.size()];

        DFS(0, 0);
        bw.write(minTotalDistance + "\n");
        bw.flush();
        bw.close();
        br.close();

        //1. 집과 치킨집의 좌표를 list에 저장해둔다.
        //2. M개의 치킨집을 돌아가면서 선정 후, 각 집에서 걸리는 거리의 합을 구하고, 최솟값을 갱신해준다.
        //  M개의 치킨집을 어떻게 차례로 뽑지? -> backtracking
        //  5개의 치킨집 중 4개 -> 1234, 1235, 1245, 1345, 2345
    }

    static void DFS(int start, int chickenCnt) {
        //치킨집을 모두 선정했으면, 각 집에서 현재 치킨집들에 대한 최소 거리의 합을 구한다.
        if (chickenCnt == M) {
            int curTotalDistance = 0;

            //각 집에서 치킨집까지의 최소 거리를 각각 구한다.
            for (int i = 0; i < houses.size(); i++) {
                int temp = Integer.MAX_VALUE;

                for (int p = 0; p < chickens.size(); p++) {
                    if (isOpenedChicken[p]) {
                        int distance = Math.abs(houses.get(i).x - chickens.get(p).x)
                                + Math.abs(houses.get(i).y - chickens.get(p).y);

                        temp = Math.min(temp, distance);
                    }
                }

                curTotalDistance += temp;
            }

            minTotalDistance = Math.min(minTotalDistance, curTotalDistance);
            return;
        }

        //backtracking
        //모든 치킨집들을 돌아가면서 M개씩 뽑아야한다.
        for (int i = start; i < chickens.size(); i++) {
            isOpenedChicken[i] = true; //방문(선정) 처리 해주고, 이후에 합을 계산할때 방문한 치킨집들에 대한 거리만 계산
            DFS(i + 1, chickenCnt + 1);
            isOpenedChicken[i] = false;
        }
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}