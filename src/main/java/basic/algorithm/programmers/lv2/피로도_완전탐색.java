package basic.algorithm.programmers.lv2;

public class 피로도_완전탐색 {

    static boolean[] visited;
    static int currentVisitCount;
    static int answer;

    static int solution(int k, int[][] dungeons) {
        //두번째 요소, 즉 소모 피로도가 적은것부터 하면 된다.
        //단, 최소 필요 피로도 >= k 여야만 한다.
        visited = new boolean[dungeons.length];

        //완전탐색
        for (int i = 0; i < dungeons.length; i++) {
            dfs(i, k, currentVisitCount, dungeons);
        }

        return answer;
    }

    static void dfs(int startVertex, int k, int currentVisitCount, int[][] dungeons) {
        visited[startVertex] = true;

        //최소 피로도 충족 시 방문
        if (dungeons[startVertex][0] <= k) {
            currentVisitCount++;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                dfs(i, k - dungeons[startVertex][1], currentVisitCount, dungeons);
            }
        }

        //방문 횟수가 최대인 경우
        if (currentVisitCount > answer) {
            answer = currentVisitCount;
        }

        visited[startVertex] = false;
    }
}
