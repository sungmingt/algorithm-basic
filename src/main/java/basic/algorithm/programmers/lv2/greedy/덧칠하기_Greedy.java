package basic.algorithm.programmers.lv2.greedy;

public class 덧칠하기_Greedy {
    //페인트 길이 n미터인 벽
    //벽을 1미터 길이의 구역 n개로 나눈다.
    //각 구역의 왼쪽부터 n번까지 번호를 붙임

    //페인트 롤러의 길이는 m미터
    //벽에 한번 칠할때
    //  1. 벽에서 벗어나면 안됨
    //  2. 구역의 일부분만 칠하면 안됨

    public int solution(int n, int m, int[] section) {
        //어차피 첫번째 요소부터 한번 칠해야 한다.
        //그럼 m만큼 칠하고 난 후에 나오는 첫번째 요소도 칠해야 한다는 뜻이다.
        int answer = 0;
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < section.length; i++) {
            //칠하지 않았다면
            if (!visited[section[i]]) {
                //페인트 사용
                answer++;

                //배열 밖으로 나가는 경우 -> break
                if(visited.length <= section[i] + m) break;

                for (int j = section[i]; j < section[i] + m; j++) {
                    //m만큼 칠해준다
                    visited[j] = true;
                }
            }
        }

        return answer;
    }
}
