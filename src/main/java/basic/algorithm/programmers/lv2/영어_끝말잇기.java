package basic.algorithm.programmers.lv2;

import java.util.ArrayList;

public class 영어_끝말잇기 {  //테스트 케이스 17, 19 오류

    public static void main(String[] args) {
        int[] solution = solution(2, new String[]{"land", "dream", "mom", "mom"});
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = {};  //{탈락하는 사람 번호, 몇번재 차례에 탈락하는지}  ->  {(outIndex % n) + 1, (outIndex + 1 / n)}

        int outIndex = 0;
        ArrayList<String> used = new ArrayList<>();
        used.add(words[0]);

        //끝말이 아니거나 했던 단어이면 탈락
        for (int i = 1; i < words.length; i++) {
            String before = words[i - 1];
            String now = words[i];

            if ((now.charAt(0) != before.charAt(before.length() - 1)) || used.contains(now)) {
                outIndex = i;

                if(outIndex <= n) return new int[]{outIndex + 1, 1};
                else{
                    return new int[]{(outIndex % n) + 1, ((outIndex + 1) % n == 0 ? (outIndex + 1) / n : (outIndex + 1) / n + 1)};
                }
            }

            used.add(now);
        }

        return new int[]{0, 0};
        //2명
        //outIndex : 1
        //답 : [2, 1]

        //2aud
        //outIndex : 3
        //답 : [2, 2]

        //3명, 단어 4개
        //outIndex : 3
        //답 : [1, 2]

        //4명, 단어 4개
        //outIndex : 3
        //답 : [4, 1]

        //4명, 단어 4개
        //outIndex : 1
        //답 : [2, 1]

        //3명, 9개
        //outIndex : 8
        //답 : [3, 3]
    }
}
