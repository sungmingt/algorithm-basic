package basic.algorithm.baekjoon.twopointer;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class boj_2607 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int result = 0;

        int count = sc.nextInt();
        String input = sc.next();
        //기존의 단어와 주어진 단어의 문자가 일치할 경우 하나씩 지우고,
        // 마지막에 두 단어에 남은 문자 개수가 각각 1개이거나, 1개 0개이거나 그 반대의 경우 비슷한 단어이다

        //단어 하나씩 비교
        for (int i = 0; i < count - 1; i++) {
            String word = input;
            String next = sc.next();

            for (int j = 0; j < next.length(); j++) {

                for (int k = 0; k < word.length(); k++) {
                    //같은 문자가 있는 경우 각 문자열에서 문자 삭제
                    if (next.charAt(j) == word.charAt(k)) {
                        String newNext = next.replaceFirst(String.valueOf(next.charAt(j)), "");
                        String newWord = word.replaceFirst(String.valueOf(word.charAt(k)), "");
                        next = newNext;
                        word = newWord;
                        j -= 1;
                        break;
                    }
                }
            }

            if (word.length() + next.length() <= 1 || (word.length() == 1 && next.length() == 1)) {
                result++;
            }
        }

        System.out.println(result);
    }
}
