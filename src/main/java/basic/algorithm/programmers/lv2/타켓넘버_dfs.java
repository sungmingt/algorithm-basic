package basic.algorithm.programmers.lv2;

public class 타켓넘버_dfs {

    //https://school.programmers.co.kr/learn/courses/30/lessons/43165

    int answer = 0;

    public int solution(int[] numbers, int target) {
        //백트래킹 + dfs를 통해 타겟 넘버를 만든다.
        //4 1 2 1
        //순서대로 탐색해야 하기 때문에, 4부터 탐색하는 경우, -4부터 탐색하는 경우 2가지

        dfs(1, numbers[0], numbers, target);
        dfs(1, numbers[0] * -1, numbers, target);
        return answer;
    }

    private void dfs(int depth, int sum, int[] numbers, int target) {
        if(depth == numbers.length) {
            if(sum == target) {
                answer++;
            }

            return;
        }

        dfs(depth + 1, sum + numbers[depth], numbers, target);
        dfs(depth + 1, sum - numbers[depth], numbers, target);
    }
}
