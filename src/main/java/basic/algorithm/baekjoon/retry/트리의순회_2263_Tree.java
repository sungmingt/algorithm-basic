package basic.algorithm.baekjoon.retry;

import java.util.Scanner;

public class 트리의순회_2263_Tree {

    static int[] inOrder;
    static int[] postOrder;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        inOrder = new int[N];
        postOrder = new int[N];

        for (int k = 0; k < N; k++) {
            int node = sc.nextInt();
            inOrder[k] = node;
        }

        for (int k = 0; k < N; k++) {
            int node = sc.nextInt();
            postOrder[k] = node;
        }

        //inOrder : 왼 - 루트 - 오
        //postOrder : 왼 - 오 - 루트
        //preOrder : 루트 - 왼 - 오

        //postOrder의 마지막 요소는 root이다.
        //inOrder에서 root를 기준으로 왼쪽 자식 노드, 오른쪽 자식 노드로 나뉜다.
        //재귀를 통해 나뉘어진 부분에 대해 같은 동작을 반복한다.

        //1. postOrder의 마지막 요소를 answer에 추가
        //2. postOrder의 위치를 inOrder에서 찾고, 해당 인덱스를 기준으로 앞/뒤 분리한다.
        //3. inOrder의 시작/끝 인덱스를 통해 앞/뒤 인덱스를 함께 입력한다.

        getPreOrder(0, N - 1, 0, N - 1);
    }

    static void getPreOrder(int in_start, int in_end, int post_start, int post_end) {
        if (in_start > in_end || post_start > post_end) {
            return;
        }

        //postOrder에서 root 구하기
        int root = postOrder[post_end];
        System.out.print(root + " ");

        //inOrder에서 root의 index 찾기
        int newIn_end = 0;
        for (int i = in_start; i < in_end; i++) {
            if(inOrder[i] == root){
                newIn_end = i;
                break;
            }
        }

        //inOrder에서 root index 기준 왼쪽에 몇개 있는지
        int newIn_cnt = newIn_end - in_start;

        //왼쪽 자식노드 탐색
        getPreOrder(in_start, newIn_end - 1, post_start, post_start + newIn_cnt - 1);
        //오른쪽 자식노드 탐색
        getPreOrder(newIn_end + 1, in_end, post_start + newIn_cnt, post_end - 1);
    }
}
