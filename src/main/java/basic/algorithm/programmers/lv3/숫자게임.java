package basic.algorithm.programmers.lv3;

import java.util.Arrays;

public class 숫자게임 {

    static int solution(int[] A, int[] B) {
        //숫자가 더 큰쪽이 승점 1점 get
        //B팀의 최대 승점
        //정렬 후 해당 숫자보다 큰 수 중 가장 작은수 넣기
        int answer = 0;
        boolean[] visited = new boolean[B.length];
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            int start = 0;
            int end = B.length - 1;

            //이분탐색 기준 : A배열의 해당 숫자
            //이분탐색 대상 : B배열에서 A숫자보다 큰수중 가장 작은수 -> lower bound
            while (start < end) {
                int mid = (start + end) / 2;

                //목표 수보다 작다면
                if (B[mid] < value) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }

            //아직 사용안했다면
            if (!visited[start] && A[i] < B[start]) {
                visited[start] = true;
                answer++;
                continue;
            }

            for (int j = start; j < visited.length; j++) {
                if (!visited[j] && A[i] < B[j]) {
                    visited[j] = true;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
