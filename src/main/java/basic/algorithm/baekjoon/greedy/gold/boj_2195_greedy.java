package basic.algorithm.baekjoon.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2195_greedy {

    static String origin;
    static String target;
    static int targetFromIdx;
    static int copyCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        origin = br.readLine();
        target = br.readLine();

        while (targetFromIdx < target.length()) {
            int maxLen = 0;

            //origin의 모든 시작 위치를 기준으로 비교
            for (int i = 0; i < origin.length(); i++) {
                int len = 0;

                while (i + len < origin.length()
                        && targetFromIdx + len < target.length()
                        && origin.charAt(i + len) == target.charAt(targetFromIdx + len)) {
                    len++;
                }

                maxLen = Math.max(maxLen, len);
            }

            targetFromIdx += maxLen;
            copyCount++;
        }

        System.out.println(copyCount);

        //복사를 최소 개수로 사용해야함.
        // -> 최대 길이로 복사햐애한다.
        // -> origin의 어떤 인덱스에서 복사할때 최대 길이가 되는지 구한다.

        //origin의 모든 시작 인덱스 i에 대해 target[targetFromIdx...]과 몇 글자까지 연속으로 일치하는지 계산
        //그중 최대 길이만큼 갱신
    }
}
