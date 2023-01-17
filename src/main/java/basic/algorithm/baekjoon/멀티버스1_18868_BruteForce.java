package basic.algorithm.baekjoon;

import java.util.Scanner;

public class 멀티버스1_18868_BruteForce {

    static int[][] universe;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        universe = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                universe[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < universe.length - 1; i++) {
            for (int r = i + 1; r < universe.length; r++) {
                boolean isEqual = true;

                for (int j = 0; j < universe[i].length - 1; j++) {
                    for (int k = j + 1; k < universe[i].length; k++) {

                        if (!isSame(i, r, j, k)) {
                            isEqual = false;
                            break;
                        }
                    }
                    if(!isEqual) break;
                }
                if(isEqual) answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean isSame(int prevSpace, int curSpace, int prevPlanet, int curPlanet) {
        return ((universe[prevSpace][prevPlanet] == universe[prevSpace][curPlanet])
                && (universe[curSpace][prevPlanet] == universe[curSpace][curPlanet]))

                || ((universe[prevSpace][prevPlanet] < universe[prevSpace][curPlanet])
                && (universe[curSpace][prevPlanet] < universe[curSpace][curPlanet]))

                || ((universe[prevSpace][prevPlanet] > universe[prevSpace][curPlanet])
                && (universe[curSpace][prevPlanet] > universe[curSpace][curPlanet]));
    }
}
