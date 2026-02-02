package basic.algorithm.baekjoon.priorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2879_greedy {

    static int N;
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];

        //input
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int prev = 0;

        //이전 작업과 현재 작업의 변화 방식에 따라 다르게 처리한다.
        //1. 부호가 같을때
        //  - 현재 작업량 <= 이전 작업량
        //      - 이때는 이전 작업에서 현재 작업까지 모두 처리됐다고 보면 되기때문에, 별도의 작업을 하지 않는다.
        //  - 현재 작업량 > 이전 작업량
        //      - 이때는 이전 작업량에서 추가 작업이 생겼기 때문에, 추가 작업을 해준다.
        //2. 부호가 다를때
        //  - 현재 작업량만큼 추가 작업을 해준다.

        //핵심: 처음에는 다른 부호가 나올때까지 탐색하고 최솟값을 기준으로 처리하려고 했지만,
        // 여러 구간을 탐색할 필요없이 2개씩 비교해서 앞선 작업량이 더 많다면 현재 작업은 이미 포함되어 처리되었다고 생각하면 된다.

        //greedy
        for (int i = 0; i < N; i++) {
            int cur = B[i] - A[i];

            //부호가 같을 때
            if ((prev > 0 && cur > 0) || (prev < 0 && cur < 0)) {
                answer += Math.max(0, Math.abs(cur) - Math.abs(prev));
            }
            //부호가 다를 때 (또는 prev == 0)
            else {
                answer += Math.abs(cur);
            }

            prev = cur;
        }

        System.out.println(answer);
    }
}
