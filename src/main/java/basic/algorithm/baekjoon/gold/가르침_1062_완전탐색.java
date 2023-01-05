package basic.algorithm.baekjoon.gold;

import java.util.Scanner;

public class 가르침_1062_완전탐색 { //마저 풀이

    //1545 996
    //2541
    //2200
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.nextLine().replace("anta", "").replace("tica", "");
        }

        //K개의 글자를 가르칠때, 읽을 수 있는 단어의 최대 개수
        //a, n, t, i, c / 5개는 항상 단어에 들어감. -> K < 5 이면 항상 결과는 0개.
        if(K < 5) {
            System.out.println(0);
            System.exit(0);
        } else if (K == 26) {  //K = 26 이면 모든 단어를 읽을 수 있다. -> N 반환
            System.out.println(N);
            System.exit(0);
        }

        boolean[] visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
    }
}
