package basic.algorithm.baekjoon.dataStructure.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_13414_dataStructure {

    static int K, L;
    static LinkedHashSet<String> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        queue = new LinkedHashSet<>();

        //순서보장 + 중복x or 탐색빠른
        //대기목록 최대 50만 -> 큐는 비효율
        //LinkedHashSet -> 순서를 보장하는 hashSet

        for (int i = 0; i < L; i++) {
            String num = br.readLine();
            //중복값일 경우 -> 제거 후 마지막에 추가
            if (queue.contains(num)) {
                queue.remove(num);
            }

            queue.add(num);
        }

        int order = 1;
        for (String n : queue) {
            System.out.println(n);

            if (order == K) break;
            order++;
        }
    }
}
