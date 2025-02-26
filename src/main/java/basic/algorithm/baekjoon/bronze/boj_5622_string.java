package basic.algorithm.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_5622_string {

    static int totalTimeSpent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split("");
        //1번은 2초 소요, 이후 각 1초씩 더 소요
        //  -> 각 문자가 소속된 번호를 구하고, 해당 번호 + 1 의 값을 totalTimeSpent에 추가

        for (int i = 0; i < word.length; i++) {
            String s = word[i];

            switch (s) {
                case "A" : case "B" : case "C" :
                    totalTimeSpent += 3;
                    break;
                case "D" : case "E" : case "F" :
                    totalTimeSpent += 4;
                    break;
                case "G" : case "H" : case "I" :
                    totalTimeSpent += 5;
                    break;
                case "J" : case "K" : case "L" :
                    totalTimeSpent += 6;
                    break;
                case "M" : case "N" : case "O" :
                    totalTimeSpent += 7;
                    break;
                case "P" : case "Q" : case "R" : case "S" :
                    totalTimeSpent += 8;
                    break;
                case "T" : case "U" : case "V" :
                    totalTimeSpent += 9;
                    break;
                case "W" : case "X" : case "Y" : case "Z" :
                    totalTimeSpent += 10;
                    break;
            }
        }

        System.out.println(totalTimeSpent);
    }
}
