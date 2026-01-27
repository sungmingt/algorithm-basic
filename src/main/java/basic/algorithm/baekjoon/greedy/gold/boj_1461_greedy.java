package basic.algorithm.baekjoon.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1461_greedy {

    static int N, M;
    static int[] books;
    static int total;
    static List<Integer> neg;
    static List<Integer> pos;

    public static void main(String[] args) throws IOException {

        //M개씩 묶어서 [가장 먼 거리 * 2] 를 순차적으로 처리한다.
        //이때, 거리가 가장 먼 곳은 왕복이 아닌 편도로 해야함.
        //따라서, 음수/양수를 나누고 M개씩 [가장 먼 거리 * 2] 처리한 뒤, 가장 먼 곳의 거리만큼 빼주면 된다.

        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        books = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(st.nextToken());
        }

        //sort
        Arrays.sort(books);

        //음수/양수 분리
        neg = new ArrayList<>();
        pos = new ArrayList<>();

        for (int x : books) {
            if (x < 0) neg.add(-x); //절댓값으로 저장
            else pos.add(x);
        }

        //내림차순 정렬 (가장 먼 거리부터 처리)
        neg.sort(Collections.reverseOrder());
        pos.sort(Collections.reverseOrder());

        int maxDist = 0;
        if (!neg.isEmpty()) maxDist = Math.max(maxDist, neg.get(0));
        if (!pos.isEmpty()) maxDist = Math.max(maxDist, pos.get(0));

        //음수 방향 처리
        for (int i = 0; i < neg.size(); i += M) {
            total += neg.get(i) * 2;
        }

        //양수 방향 처리
        for (int i = 0; i < pos.size(); i += M) {
            total += pos.get(i) * 2;
        }

        //가장 먼 곳은 편도 이동
        total -= maxDist;

        System.out.println(total);
    }
}
