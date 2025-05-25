package basic.algorithm.baekjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_13305_greedy {

    static int N;
    static long[] distance;
    static long[] pricePerLiter;
    static long cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        distance = new long[N - 1];
        pricePerLiter = new long[N];

        //input distance
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        //input price
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pricePerLiter[i] = Long.parseLong(st.nextToken());
        }

        //현재 도시의 기름 가격보다 다음 도시의 가격이 더 비싸다면 현재 도시에서 주유한다.
        //현재 도시의 기름 가격보다 작을때까지 순회

        int cur = 0;
        while (cur < N - 1) {  //어차피 마지막 도시의 주유 가격(pricePerLiter[N-1])은 필요 없는 값
            cost += pricePerLiter[cur] * distance[cur];

            int next = cur + 1;
            while (next < N - 1) {
                if (pricePerLiter[cur] <= pricePerLiter[next]) {
                    cost += pricePerLiter[cur] * distance[next];
                    next++;
                } else {
                    break;
                }
            }

            cur = next;
        }

        System.out.println(cost);
    }
}
