package basic.algorithm.baekjoon.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_17478_recursive {

    static String question = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";

    static String fir = "\"재귀함수가 뭔가요?\"";
    static String sec = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    static String third = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    static String fourth = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";

    static String finalQuestion = "\"재귀함수가 뭔가요?\"";
    static String finalAnswer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String finalSentence = "라고 답변하였지.";

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        sb.append(question).append("\n");

        doRecursive("", 0);

        System.out.println(sb);
    }

    private static void doRecursive(String prefix, int depth) {
        if (depth == N) {
            sb.append(prefix).append(finalQuestion).append("\n");
            sb.append(prefix).append(finalAnswer).append("\n");
            sb.append(prefix).append(finalSentence).append("\n");
            return;
        } else {
            sb.append(prefix).append(fir).append("\n");
            sb.append(prefix).append(sec).append("\n");
            sb.append(prefix).append(third).append("\n");
            sb.append(prefix).append(fourth).append("\n");

            doRecursive(prefix + "____", depth + 1);
        }

        sb.append(prefix).append(finalSentence).append("\n");
    }
}
