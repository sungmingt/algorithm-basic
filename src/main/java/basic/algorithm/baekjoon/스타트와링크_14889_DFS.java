package basic.algorithm.baekjoon;

import java.util.Scanner;

public class 스타트와링크_14889_DFS {  //다시 풀어보기 (재귀 활용)

    static int[][] arr;
    public static void main(String[] args) {
        //N명 (1 ~ N)
        //능력치 : i번과 j번이 같은 팀일때 팀에 더해지는 능력치 (arr[i][j] + arr[j][i])
        //팀 능력치 : 팀의 모든 쌍의 능력치 합

        //두 팀의 능력치 차이가 최솟값 구하기

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        //NxN 배열 생성 (능력치 테이블)
        arr = new int[N][N];   //0 ~ N-1


        //0  5  9  6
        //5  0  6 10
        //9  6  0  7
        //6 10  7  0

        //팀이 되는 경우의 수
        //1,2 vs 3,4
        //1,3 vs 2,4
        //1,4 vs 2,3

        //1,2,3 vs 4,5,6
        //1,2,4 vs 3,5,6
        //1,2,5 vs 3,4,6
        //1,2,6 vs 3,4,5
        //1,3,4 vs 2,5,6
        //1,3,5 vs 2,4,6
        //1,3,6 vs 2,4,5
        //1,4,5 vs 2,3,6
        //1,4,6 vs 2,3,5
        //1,5,6 vs 2,3,4

    }
}
