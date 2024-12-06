package basic.algorithm.programmers;

import java.util.HashMap;

public class programmers_hash_전화번호목록 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/42577?language=java

    public static boolean solution(String[] phone_book) {
        //접두어가 있으면 false, 없으면 true;

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            hm.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int k = 1; k < phone_book[i].length(); k++) {
                if (hm.containsKey(phone_book[i].substring(0, k))) {
                    return false;
                }
            }
        }

        return true;
    }
}
