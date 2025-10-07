package basic.algorithm.programmers.lv2;

import java.util.Arrays;

public class 전화번호목록_hash {
    //https://school.programmers.co.kr/learn/courses/30/lessons/42577?language=java

    public static boolean solution(String[] phone_book) {
        //길이 순 오름차순 정렬.
        //현재 번호의 길이만큼 처음부터 잘랐을때, 일치한다면 접두사

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            String cur = phone_book[i];
            int length = cur.length();

            for (int k = i + 1; k < phone_book.length; k++) {
                String str = phone_book[k];
                String target = str.substring(0, length);

                if (cur.equals(target)) {
                    return true;
                }
            }
        }

        return false;
    }
}
