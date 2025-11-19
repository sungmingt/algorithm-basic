package basic.algorithm.baekjoon.dataStructure;

import java.io.*;
import java.util.*;

public class boj_11003_deque { //다시 풀어보기

    static int N, L;
    static int[] arr;
    static int[] min;
    static Deque<Integer> deque;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        //L = 2
        //D[3] = A[3-2+1]~A[3] 중의 최솟값

        //Deque로 구간 관리 (idx 저장)
        //요소가 들어올때마다
        // 1. 범위를 벗어난 idx가 존재할경우 모두 삭제
        // 2. 해당 요소보다 큰 값은 모두 삭제. (어차피 최소가 될수없음)

        deque = new ArrayDeque<>();
        arr = new int[N];
        min = new int[N];

        //input arr
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        deque.offerFirst(0);
        sb.append(arr[0]).append(" ");

        //구간 탐색
        for (int i = 1; i < N; i++) {

            //범위를 벗어난 요소 인덱스 제거
            while (!deque.isEmpty() && deque.peekFirst() < i - L + 1) {
                deque.pollFirst();
            }

            //뒤에서부터(큰값부터) 현재 요소보다 큰 값은 모두 지운다.
            while (!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            sb.append(arr[deque.peekFirst()]).append(" ");
        }

        System.out.println(sb);
    }

    //비슷한 유형의 문제
    int[] solution(int[] queries) {
        //queries는 새로 지어질 집들의 위치이고, 집이 지어질때마다 현재 지어진 집들 중, 연속된 집의 길이가 가장 긴 것을 출력하는 문제.
        //집이 지어질때마다 출력하면 됨.
        //지어질 집의 왼쪽/오른쪽 중 한 곳에만 이미 집이 지어져있다. (양쪽 모두 존재 X)

        //조건
        //queries.length <= 10^5
        //-10^9 <= queries[i] <= 10^9

        //배열로 plus[1000000001], minus[1000000001], 이렇게 하려고했지만, 효율성이 너무 안좋음. 코드는 맞음.
        //해답 -> HashMap으로 구간관리.
        //left, right

        int n = queries.length;
        int[] result = new int[n];

        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int x = queries[i];
            if (left.containsKey(x)) { //이미 지어짐 (중복 방지)
                result[i] = maxLen;
                continue;
            }

            int L = x;
            int R = x;

            if (right.containsKey(x - 1)) {
                L = right.get(x - 1); //왼쪽 구간 확장
                right.remove(x - 1);
            }
            if (left.containsKey(x + 1)) {
                R = left.get(x + 1); //오른쪽 구간 확장
                left.remove(x + 1);
            }

            //새로운 구간 등록
            left.put(L, R);
            right.put(R, L);

            maxLen = Math.max(maxLen, R - L + 1);
            result[i] = maxLen;
        }

        return result;
    }
}
